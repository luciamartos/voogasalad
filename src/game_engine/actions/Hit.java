package game_engine.actions;

import javafx.geometry.Bounds;
import javafx.geometry.Side;
import states.Physics;
import states.State;
import game_data.Location;
import game_data.Sprite;
import game_engine.SpritePhysics;

/**
 * @author Alex
 *
 */

public class Hit implements Action {
	
	private Sprite myPlayerSprite;
	private Side mySide;
	private Sprite block;
	

	public Hit(Sprite player,  Side aSide, Sprite block) {
		myPlayerSprite = player;
		mySide = aSide;
		this.block = block;
	}

	@Override
	public void act() {
		
		
		//get new Velocity –– gets horizontal or vertical components to zero

		setNewVelocity();
	//	setNewAcceleration();
	}
	
	private void setNewVelocity() {
		if(mySide==Side.TOP){
			myPlayerSprite.getMyLocation().setLocation(myPlayerSprite.getMyLocation().getXLocation(), block.getMyLocation().getYLocation()-myPlayerSprite.getMyHeight());
			//myPlayerSprite.setMyLocation(new Location(myPlayerSprite.getMyLocation().getXLocation(), block.getMyLocation().getYLocation()-myPlayerSprite.getMyHeight(),  0));
//			if(myPlayerSprite.getMyYVelocity() >=0)
			myPlayerSprite.setMyYVelocity(0);
			myPlayerSprite.setMyYAcceleration(0);
		}
			
//		if(mySide == Side.LEFT || mySide == Side.RIGHT) {
//			myPlayerSprite.setMyXVelocity(0);
//		}
//		if(mySide==Side.TOP){
//			System.out.println("top");
//			myPlayerSprite.setMyYVelocity(0);
//		}
//		if(mySide==Side.BOTTOM){
//			myPlayerSprite.setMyYVelocity(-myPlayerSprite.getMyYVelocity());
//		}
	}
	private void setNewAcceleration(){
		SpritePhysics mySpritePhysics = null;
		for(State s: myPlayerSprite.getStates()){
			if(s instanceof Physics){
				mySpritePhysics = ((Physics) s).getPhysics();
			}
		}
		if(mySide == Side.LEFT || mySide==Side.RIGHT){
			myPlayerSprite.setMyXAcceleration(-mySpritePhysics.getHorizontalGravity());
		}
//		if(mySide==Side.TOP){
//			myPlayerSprite.setMyYAcceleration(-mySpritePhysics.getVerticalGravity());
//		}
		
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