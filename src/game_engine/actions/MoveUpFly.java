package game_engine.actions;

import game_data.Location;
import game_data.Sprite;

public class MoveUpFly extends Move {

	public MoveUpFly(Sprite aSprite, double aVelocity, double aTimeStep) {
		super(aSprite, aVelocity, aTimeStep);
	}
	@Override
	public Location changeCoordinates(){
		System.out.println("old X" + myOldLocation.getXLocation() + "old Y" + myOldLocation.getYLocation());
		myNewLocation.setLocation(myOldLocation.getXLocation(), myOldLocation.getYLocation()-myVelocity*timeStep);
		System.out.println("X" + myNewLocation.getXLocation() + "Y" + myNewLocation.getYLocation());
		
		return myNewLocation;
	}
//	public void setVelocity(){
//		mySprite.setMyYVelocity(-myVelocity);
//	}

}