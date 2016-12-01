package game_engine.actions;

import game_data.Location;
import game_data.Sprite;
/**
 * can move sprites given the sprite and the instantaneous velocity of the sprite
 * Should we make it moveHorizontal and moveVertical and just input negative velocities when you want to move left and down?
 * idk 
 * 
 * @author Katrina Zhu
 */
public abstract class Move implements Action {
	protected Sprite mySprite;
	protected Location myOldLocation;
	protected Location myNewLocation;
	protected double myVelocity;
	protected double timeStep;
	public Move(Sprite aSprite, double aVelocity, double timeStep) {
		mySprite=aSprite;
		myVelocity=aVelocity;
		myOldLocation=mySprite.getMyLocation();
		double heading = myOldLocation.getMyHeading();
		myNewLocation = new Location(0, 0, heading);
		this.timeStep = timeStep;
	}

	@Override
	public void act() {
		mySprite.setMyLocation(changeCoordinates());
		//setVelocity();
	}
	public abstract Location changeCoordinates();
	//public abstract void setVelocity();
	
}
