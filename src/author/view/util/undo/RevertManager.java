// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)

/*
 * This class is the top level entity for my undo functionality in the authoring
 * environment front end. This class, in combination with GameChangeEvent, represents
 * several facets of good design.
 * 
 * First, this framework relies heavily on the concept of APIs and Factory Implementation.
 * From an external API perspective, RevertManagerFactory limits external access to
 * RevertManager to just that through its external API (IRevertManager). Since this class is
 * package friendly, the only way to instantiate an instance of this class is through the
 * factory, which returns only the external API.
 * 
 * Second, this framework completely fulfills the open-closed principle. For anyone looking
 * to implement this undo manager, it will work on any class that implements Observable.
 * The user only needs to extend RevertManager and GameChangeEvent and override a couple 
 * methods to get all the functionality that I currently have on my authoring environment.
 * 
 * The use of generic types ensures that these classes work for any class that implements
 * Observable, and will manage undo and redo without needing any access to the calling class
 * or application framework. This combined with proper inheritance and classic Interface
 * design yields a powerful API.
 * 
 * Finally, and most importantly, this class and GameChangeEvent display the powers of
 * the Observer design pattern. As is mentioned above, this framework accomplishes what
 * is essentially short-term version control (that's really what undo/redo is) on an
 * object without ever needing access to the overarching application. Since, in our case,
 * our entire authoring environment is an observer to the Game object (and its levels
 * and sprites), the RevertManager only has to listen for a change in its managed object
 * (in this case a level and its sprites) to know that it needs to take a snapshot of
 * a sprite. Then, when the calling framework wants to undo a change, calling "undo" will 
 * cause the revert manager to reset the back end object to its previous state. This will
 * then trigger the listeners in the authoring environment, propagating this change to the
 * GUI. 
 */
package author.view.util.undo;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import author.view.util.undo.game_change_event.IGameChangeEvent;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class RevertManager <K extends Observable, V extends Observable> implements IRevertManager, IRevertManagerInternal<V>{

	private Map<V, IGameChangeEvent<V>> existingEvents = new HashMap<>();
	private Deque<IGameChangeEvent<V>> eventHistory = new ArrayDeque<>();
	private Deque<IGameChangeEvent<V>> eventFuture = new ArrayDeque<>();
	
	private K managedObservable;
	
	public RevertManager(K managedObservable) {
		this.managedObservable = managedObservable;
		initObserver(managedObservable);
	}

	@Override
	public void addHistory(IGameChangeEvent<V> aGameChangeEvent) {
		this.eventHistory.push(aGameChangeEvent);
	}

	@Override
	public void addFuture(IGameChangeEvent<V> aGameChangeEvent) {
		this.eventFuture.push(aGameChangeEvent);
	}

	@Override
	public void undo() {
		if (!this.eventHistory.isEmpty()){
			IGameChangeEvent<V> gameChangeEvent = eventHistory.pop();
			eventFuture.push(gameChangeEvent);
			if (!gameChangeEvent.undo()){
				removeEvent(gameChangeEvent.getObservable());
			}
		}
	}

	@Override
	public void redo() {
		if (!this.eventFuture.isEmpty()){
			IGameChangeEvent<V> gameChangeEvent = eventFuture.pop();
			eventHistory.push(gameChangeEvent);
			gameChangeEvent.redo();
		}
	}
	
	private void initObserver(K observable){
		observable.addListener((event) -> onInvalidation(observable, this.existingEvents));
	}
	
	protected void onInvalidation(K managedObservable, Map<V, IGameChangeEvent<V>> existingEvents){
		Set<V> newObservables = getNewObservables(existingEvents.keySet(), getObservables(this.managedObservable));
		Set<V> removedObservables = getRemovedObservables(existingEvents.keySet(), getObservables(this.managedObservable));
		addObservables(newObservables);
		removeObservables(removedObservables);
	}
	
	protected void removeObservables(Collection<V> aObservables){
		aObservables.forEach((observable) -> removeEvent(observable));
	}
	
	private void removeEvent(V aObservable) {
		if (this.existingEvents.containsKey(aObservable)){
			this.existingEvents.get(aObservable).removeListener();
			this.eventHistory.removeAll(Collections.singleton(this.existingEvents.get(aObservable)));
			this.eventFuture.removeAll(Collections.singleton(this.existingEvents.get(aObservable)));
			removeObservable(this.managedObservable, aObservable);
			this.existingEvents.remove(aObservable);
		}
	}
	
	protected abstract Collection<V> getObservables(K managedObservable);
	
	protected abstract IGameChangeEvent<V> createEvent(V observable);
	
	protected abstract void removeObservable(K managedObservable, V removedObservable);
	
	protected Set<V> getNewObservables(Collection<V> aOldObservables, Collection<V> aNewObsrvables){
		Set<V> observables = new HashSet<>(aNewObsrvables);
		observables.removeAll(aOldObservables);
		return observables;
	}
	
	protected Set<V> getRemovedObservables(Collection<V> aOldObservables, Collection<V> aNewObservables){
		Set<V> observables = new HashSet<>(aOldObservables);
		observables.removeAll(aNewObservables);
		return observables;
	}
	
	protected void addObservables(Collection<V> aObservables){
		aObservables.forEach((observable) -> {
			this.existingEvents.put(observable, createEvent(observable));			
		});
	}

}
