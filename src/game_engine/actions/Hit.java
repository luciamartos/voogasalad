package game_engine.actions;

import javafx.geometry.Side;
import game_data.Sprite;

/**
 * @author Alex
 *
 */

public class Hit implements Action {
	
	private Sprite myPlayerSprite;
	private Side mySide;
	

	public Hit(Sprite player, Side aSide) {
		myPlayerSprite = player;
		mySide = aSide;
	}

	@Override
	public void act() {
		
		
		//get new Velocity –– gets horizontal or vertical components to zero

		setNewVelocity();

	}
	
	private void setNewVelocity() {
				
		if(mySide == Side.LEFT || mySide == Side.RIGHT) {
			myPlayerSprite.setMyXVelocity(0);
		}
		if(mySide==Side.TOP || mySide == Side.BOTTOM){
			myPlayerSprite.setMyYVelocity(0);
		}
	}
	
/*	private double getNewHeading(double oldHeading, double oldVelocity) {
		
		if(mySide == Side.LEFT || mySide == Side.RIGHT) {
			
			if(oldHeading > 0 && oldHeading < 180) {
				return 90;
			}
			return 270;
			
		}
		
		if(oldHeading > 270 || oldHeading < 90) {
			return  0;
		}
		return 180;

	}*/
	
	
		
}