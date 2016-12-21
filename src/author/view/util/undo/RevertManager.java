/**
 * 
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
