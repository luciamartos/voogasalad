// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)

/* 
 * This class represents good design for the same reasons as RevertManager--I won't repeat
 * the same reasons here.
 * 
 * The things to note are that the user extending my framework has the ability to define 
 * what it means for an observable to "change" in compare snapshot--and likewise the ability
 * to decide what is updated in update. These two methods allow the user to define
 * which actions can be reverted.
 */
package author.view.util.undo.game_change_event;

import author.view.util.undo.IRevertManagerInternal;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
class ConcreteGameChangeEvent extends GameChangeEvent<Sprite>{

	/**
	 * @param activeObservable
	 * @param iRevertManagerInternal
	 */
	public ConcreteGameChangeEvent(Sprite activeObservable, IRevertManagerInternal<Sprite> iRevertManagerInternal) {
		super(activeObservable, iRevertManagerInternal);
		// TODO Auto-generated constructor stub
	}
	
	protected void update(Sprite activeSprite, Sprite activeBackup){
		activeSprite.setLocation(activeBackup.getLocation());
		activeSprite.setHeight(activeBackup.getHeight());
		activeSprite.setWidth(activeBackup.getWidth());
		activeSprite.setImagePath(activeBackup.getImagePath());
	}
	
	@Override
	protected Sprite cloneObservable(Sprite observable){
		return observable.clone();
	}
	
	@Override
	protected Boolean compareSnapshot(Sprite activeSprite, Sprite snapshotSprite){
		return (activeSprite.getLocation().equals(snapshotSprite.getLocation()) && activeSprite.getImagePath().equals(snapshotSprite.getImagePath()) && activeSprite.getWidth() == snapshotSprite.getWidth() && activeSprite.getHeight() == snapshotSprite.getHeight());
	}
	

}
