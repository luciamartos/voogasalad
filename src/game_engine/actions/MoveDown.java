package game_engine.actions;

import game_data.Location;
import game_data.Sprite;

public class MoveDown extends Move {

	public MoveDown(Sprite aSprite, double aVelocity, double aTimeStep) {
		super(aSprite, aVelocity, aTimeStep);
	}
	@Override
	public Location changeCoordinates(){
		myNewLocation.setLocation(myOldLocation.getXLocation(), myOldLocation.getYLocation()+myVelocity*timeStep);
		return myNewLocation;
	}
//	@Override
//	public void setVelocity(){
//		mySprite.setMyYVelocity(myVelocity);
//	}

}