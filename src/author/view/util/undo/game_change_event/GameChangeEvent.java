/**
 * 
 */
package author.view.util.undo.game_change_event;

import java.util.ArrayDeque;
import java.util.Deque;

import author.view.util.undo.IRevertManagerInternal;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class GameChangeEvent <T extends Observable> implements IGameChangeEvent<T>{

	private IRevertManagerInternal<T> iRevertManagerInternal;
	private InvalidationListener invalidationListener;
	
	
	private T activeObservable;
	private T activeBackup;
	private Deque<T> history = new ArrayDeque<>();
	private Deque<T> future = new ArrayDeque<>();
	
	private Boolean isEditing = false;
	
	
	public GameChangeEvent(T activeObservable, IRevertManagerInternal<T> iRevertManagerInternal) {
		this.iRevertManagerInternal = iRevertManagerInternal;
		this.activeObservable = activeObservable;
		this.activeBackup = cloneObservable(this.activeObservable);
		this.iRevertManagerInternal.addHistory(this);
		initObserver(this.activeObservable);
	}

	/* (non-Javadoc)
	 * @see author.view.util.undo.game_change_event.IGameChangeEvent#undo()
	 */
	@Override
	public Boolean undo() {
		if (!this.history.isEmpty()){
			this.future.push(this.activeBackup);
			this.activeBackup = this.history.pop();
			updateObservable(this.activeObservable, this.activeBackup);
			return true;
		}
		return false;
	}

	@Override
	public Boolean redo() {
		if (!this.future.isEmpty()){
			this.history.push(activeBackup);
			this.activeBackup = this.future.pop();
			updateObservable(this.activeObservable, this.activeBackup);
			return true;
		}
		return false;
	}

	@Override
	public T getObservable() {
		return this.activeObservable;
	}
	
	@Override
	public void removeListener(){
		this.activeObservable.removeListener(this.invalidationListener);
	}
	
	private void updateObservable(T activeInstance, T activeBackup){
		this.isEditing = true;
		update(activeInstance, activeBackup);
		this.isEditing = false;
	}
	
	protected abstract void update(T activeInstance, T activeBackup);
	
	protected abstract T cloneObservable(T observable);
	
	private void createSnapShot(){
		T clone = cloneObservable(this.activeObservable);
		this.history.push(this.activeBackup);
		this.activeBackup = clone;
	}
	
	private void initObserver(T observable){
		InvalidationListener invalidationListener = ((listener) -> {
			if (!this.isEditing && (this.history.isEmpty() || !compareSnapshot(observable, this.history.peek()))){
				createSnapShot();
				this.iRevertManagerInternal.addHistory(this);
			}
		});
		observable.addListener(invalidationListener);
		this.invalidationListener = invalidationListener;
	}
	
	protected abstract Boolean compareSnapshot(T activeSnapshot, T secondarySnapshot);

}
