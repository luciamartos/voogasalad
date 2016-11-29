package game_engine.actions;

import javafx.geometry.Side;
import game_data.Sprite;

/**
 * @author Alex & James
 *
 */

public class Bounce implements Action {
	
	private double myBounceSpeed;
	private Sprite myPlayerSprite;
	private Side mySide;
	

	public Bounce(double bouncerSpeed, Sprite player, Side aSide) {
		myBounceSpeed = bouncerSpeed;
		myPlayerSprite = player;
		mySide = aSide;
	}

	@Override
	public void act() {
		
		myPlayerSprite.setMyVelocity(myPlayerSprite.getMyVelocity() + myBounceSpeed);
		double newHeading = myPlayerSprite.getMyLocation().getMyHeading();
				
		if(mySide == Side.LEFT || mySide == Side.RIGHT) {
			newHeading = 180 - newHeading;
		} else {
			newHeading = 360 - newHeading;
		}
				
		myPlayerSprite.getMyLocation().setMyHeading(newHeading);

	}
	
}


