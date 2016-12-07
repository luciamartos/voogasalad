package game_engine.actions;

import game_data.Location;
import game_data.Sprite;
/**
 * @author Katrina
 *
 */
public class MoveUpFly extends Move {

	public MoveUpFly(Sprite aSprite, double aVelocity) {
		super(aSprite, aVelocity);
	}
//	@Override
//	public Location changeCoordinates(){
//		System.out.println("old X" + myOldLocation.getXLocation() + "old Y" + myOldLocation.getYLocation());
//		myNewLocation.setLocation(myOldLocation.getXLocation(), myOldLocation.getYLocation()-myVelocity*timeStep);
//		System.out.println("X" + myNewLocation.getXLocation() + "Y" + myNewLocation.getYLocation());
//		
//		return myNewLocation;
//	}
	public void setVelocity(){
		mySprite.setMyYVelocity(-myVelocity);
	}
	public void stop(){
		return;
	}

}