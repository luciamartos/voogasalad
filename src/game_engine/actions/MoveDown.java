package game_engine.actions;

import game_data.Location;
import game_data.Sprite;
/**
 * @author Katrina
 *
 */
public class MoveDown extends Move {

	public MoveDown(Sprite aSprite, double aVelocity) {
		super(aSprite, aVelocity);
	}
/*	@Override
	public Location changeCoordinates(){
		myNewLocation.setLocation(myOldLocation.getXLocation(), myOldLocation.getYLocation()+myVelocity);
		return myNewLocation;
	}*/
	@Override
	public void setVelocity(){
		mySprite.setYVelocity(myVelocity);
	}
	public void stop(){
		return;
	}
	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new MoveDown(aSprite, this.getVelocity());
	}


}