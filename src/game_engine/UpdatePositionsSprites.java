package game_engine;

import game_data.Location;
import game_data.Sprite;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author LuciaMartos
 *
 */
public class UpdatePositionsSprites {

	public UpdatePositionsSprites() {
		// TODO Auto-generated constructor stub

	}

	private void updateSpritePosition(Sprite sprite, double timeElapsed, KeyCode myKey){
		SpritePhysics spritePhysics = sprite.getSpritePhysics();
		Location myCurrentLocation = sprite.getMyLocation();
		double curXLoc = myCurrentLocation.getXLocation();
		double curYLoc = myCurrentLocation.getYLocation();
		
		//get initial x velocity component and acceleration 
		double xVelocity = sprite.getMyVelocity()*Math.cos(sprite.getMyHeading());
		double xAcceleration =GameResources.DEFAULT_HORIZONTAL_GRAVITY.getDoubleResource();
		
		//get initial y velocity componenet and acceleration
		double yVelocity = sprite.getMyVelocity()*Math.sin(sprite.getMyHeading());
		double yAcceleration = GameResources.DEFAULT_VERTICAL_GRAVITY.getDoubleResource();
	
		
		// if a key is pressed add its corresponding acceleration and velocity
		if(KeyCode.RIGHT == myKey){
			xVelocity = xVelocity + spritePhysics.getInitRightVelocity();
			xAcceleration = xAcceleration + spritePhysics.getRightAcceleration();
		}
		if(KeyCode.LEFT == myKey){
			xVelocity = xVelocity + spritePhysics.getInitLeftVelocity();
			xAcceleration = xAcceleration + spritePhysics.getLeftAcceleration();
		}
		if(KeyCode.UP == myKey){
			yVelocity = yVelocity + spritePhysics.getInitUpVelocity();
			yAcceleration = yAcceleration + spritePhysics.getUpAcceleration();
		}
		if(KeyCode.DOWN == myKey){
			yVelocity = yVelocity + spritePhysics.getInitDownVelocity();
			yAcceleration = yAcceleration + spritePhysics.getDownAcceleration();
		}
		
		// calculate the new x and y locations
		double myXLocation = curXLoc + xVelocity*timeElapsed + 0.5*xAcceleration*Math.pow(timeElapsed,2);
		double myYLocation = curYLoc + yVelocity*timeElapsed + 0.5*yAcceleration*Math.pow(timeElapsed, 2);
		
		//update the location of the sprite
		Location myNewLocation = new Location(myXLocation, myYLocation);
		sprite.setMyLocation(myNewLocation);
	}
}
