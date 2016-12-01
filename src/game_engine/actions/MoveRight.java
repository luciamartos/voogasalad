package game_engine.actions;

import game_data.Location;
import game_data.Sprite;

public class MoveRight extends Move {

	public MoveRight(Sprite aSprite, double aVelocity, double aTimeStep) {
		super(aSprite, aVelocity, aTimeStep);
	}
	@Override
	public Location changeCoordinates(){
		myNewLocation.setLocation(myOldLocation.getXLocation()+myVelocity*timeStep, myOldLocation.getYLocation());
		myNewLocation.setMyHeading(0);
		return myNewLocation;
	}
//	public void setVelocity(){
//		mySprite.setMyXVelocity(myVelocity);
//		System.out.println("changing right velocity");
//	}

}
