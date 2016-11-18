package game_engine;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import game_data.Location;
import game_data.Sprite;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author LuciaMartos
 *
 */
public class UpdateStates {

	private EnginePlayerController enginePlayerController;
	private List<Sprite> mySpriteList;
	private double timeElapsed;
	private KeyCode myKey;
	
	public UpdateStates(EnginePlayerController enginePlayerController, double timeElapsed, KeyCode myKey) {
		this.enginePlayerController = enginePlayerController;
		this.mySpriteList = enginePlayerController.getMySpriteList();
		this.timeElapsed = timeElapsed;
		this.myKey = myKey;
		
		updateSprites();
		checkCollisions();
		checkWinOrLoss();
	}

	private void checkWinOrLoss() {
		// TODO Auto-generated method stub
		// need someway of getting from game data what the winning condition of the game is
		
		
	}

	private void checkCollisions() {
		for(Sprite spriteOne:mySpriteList){
			//REVISE THIS RECTANGLE THING
			Rectangle2D r1 = new Rectangle2D.Double(spriteOne.getMyLocation().getXLocation(), spriteOne.getMyLocation().getYLocation(), spriteOne.getWidth(), spriteOne.getHeight());
			Rectangle2D r2 = new Rectangle2D.Double(spriteOne.getMyLocation().getXLocation(), 0, spriteOne.getWidth(), spriteOne.getHeight());
			for(Sprite spriteTwo:mySpriteList){
					//check for collision (dont check a sprite with itself)
					if(spriteOne!=spriteTwo && spriteOne.getImageView().getBoundsInLocal().interects(spriteTwo.getImageView().getBoundsInLocal())){
						//find the side in which it collided
					    findSideOfCollition(r1, r2, spriteTwo);
					}
			}
		}
	}

	private void findSideOfCollition(Rectangle2D r1, Rectangle2D r2, Sprite spriteTwo) {
		Point2D upperLeft = new Point2D.Double(spriteTwo.getMyLocation().getXLocation(), spriteTwo.getMyLocation().getYLocation());
		Point2D upperRight = new Point2D.Double(r1.getX() + r1.getWidth(),
		        r1.getY());
		Point2D lowerLeft = new Point2D.Double(r1.getX(), r1.getY()
		        + r1.getHeight());
		Point2D lowerRight = new Point2D.Double(r1.getX() + r1.getWidth(),
		        r1.getY() + r1.getHeight());

		if (r2.contains(upperRight)){
		    System.out.println("UpperRight hit");
		    //Do stuff
		}

		if (r2.contains(lowerRight)) {
		    System.out.println("lowerRight hit");
		    // Do stuff
		}

		if (r2.contains(lowerLeft)) {
		    System.out.println("LowerLeft hit");
		    // Do stuff
		}

		if (r2.contains(upperLeft)) {
		    System.out.println("UpperLeft hit");
		    // Do stuff
		}
	}

	private void updateSprites() {
		for(Sprite sprite:mySpriteList){
			updateSpritePosition(sprite);
		}
		
	}

	//TODO be revised. how is the new heading calculated!? and 
	private void updateSpritePosition(Sprite sprite){
		SpritePhysics spritePhysics = sprite.getSpritePhysics();
		Location myCurrentLocation = sprite.getMyLocation();
		double curXLoc = myCurrentLocation.getXLocation();
		double curYLoc = myCurrentLocation.getYLocation();
		
		//get initial x velocity component and acceleration 
		double xVelocity = sprite.getMyVelocity()*Math.cos(myCurrentLocation.getMyHeading());
		double xAcceleration =GameResources.DEFAULT_HORIZONTAL_GRAVITY.getDoubleResource();
		
		//get initial y velocity component and acceleration
		double yVelocity = sprite.getMyVelocity()*Math.sin(myCurrentLocation.getMyHeading());
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
		Location myNewLocation = new Location(myXLocation, myYLocation, myCurrentLocation.getMyHeading());
		sprite.setMyLocation(myNewLocation);
	}
	
}
