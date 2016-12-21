// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)

/* 
 * This class, in combination with RevertManager, represents multiple instances of good design.
 * 
 * shows one of the many uses of 
 * the Observer pattern in our authoring environment. 
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
