package game_engine;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import game_data.Location;
import game_data.Sprite;
import game_data.characteristics.Characteristic;
import game_engine.actions.Action;
import javafx.geometry.Side;
import javafx.scene.input.KeyCode;

/**
 * TODO make sure that player doesnt run into walls or thigns 
 * NOTE: doing the runKeyCalls and then updating sprite posistions separately might lead to an issue with glitches
 * CHECK: CALCULATING HEARDING FROM THE VERTICAL (NOON) CHECK CORRECT CALC FOR VEL
 * @author LuciaMartos
 *
 */

public class UpdateStates {

	private EnginePlayerController enginePlayerController;
	private List<Sprite> mySpriteList;
	private double timeElapsed;
	private KeyCode myKey;
	private Map<KeyCode, Action> myKeyMap;
	private Set<KeyCode> myKeys;
	
	public UpdateStates(EnginePlayerController enginePlayerController, double timeElapsed, Set<KeyCode> myKeys) {
		this.enginePlayerController = enginePlayerController;
		this.mySpriteList = enginePlayerController.getMySpriteList();
		this.timeElapsed = timeElapsed;
		this.myKeys = myKeys;
		
		executeCharacteristics();
		runKeyCalls();
		updateSpritePositions();
		checkWinOrLoss();
	}

	
	private void runKeyCalls() {
		for(KeyCode myKey: myKeys){
			if(myKeyMap.containsKey(myKey)){
				myKeyMap.get(myKey).act();
			}
		}	
	}


	private void executeCharacteristics() {
		for(Sprite mySprite:mySpriteList){
			Set<Characteristic> characteristics = mySprite.getCharacteristics();
			for(Characteristic myCharacteristic:characteristics){
				myCharacteristic.toAct();
			}
		}
	}


	private Map<Sprite, Side> getListOfSpritesCollided(Sprite targetSprite){
		Map<Sprite, Side> collisionSprites = new HashMap<Sprite, Side>();
		
		for(Sprite mySprite:mySpriteList){
			if(mySprite != targetSprite && mySprite.getImageView().getBoundsInLocal().interects(targetSprite.getImageView().getBoundsInLocal())){
//			    double x = Math.abs(mySprite.getMyLocation().getXLocation() - targetSprite.getMyLocation().getXLocation());
//			    double y = Math.abs(mySprite.getMyLocation().getYLocation() - targetSprite.getMyLocation().getXLocation());
				findSideOfCollition(mySprite, targetSprite);
			}
		}	
		return collisionSprites;
	}

	//CLARIFY: does the x and y loc represent the middle or the left top corner or what?
	private  Side findSideOfCollition(Sprite mySprite, Sprite targetSprite) {
		if(mySprite.getMyLocation().getYLocation() <= targetSprite.getMyLocation().getYLocation()){
			return Side.BOTTOM;
		}
		if(mySprite.getMyLocation().getYLocation() >= targetSprite.getMyLocation().getYLocation() + targetSprite.getHeight()){
			return Side.TOP;
		}
		if(mySprite.getMyLocation().getXLocation() < targetSprite.getMyLocation().getXLocation()){
			return Side.LEFT;
		}
		if(mySprite.getMyLocation().getXLocation() > targetSprite.getMyLocation().getXLocation()){
			return Side.RIGHT;
		}
		
	}

	private void checkWinOrLoss() {
		// TODO Auto-generated method stub
		// need someway of getting from game data what the winning condition of the game is
		
	}

	private void updateSpritePositions() {
		for(Sprite sprite:mySpriteList){
			updateSpritePosition(sprite);
		}	
	}

	//TODO CALCULATING HEARDING FROM THE VERTICAL (NOON) CHECK CORRECT CALC FOR VEL
	private void updateSpritePosition(Sprite sprite){
		SpritePhysics spritePhysics = sprite.getSpritePhysics();
		Location myCurrentLocation = sprite.getMyLocation();
		double curXLoc = myCurrentLocation.getXLocation();
		double curYLoc = myCurrentLocation.getYLocation();
		
		//get initial x velocity component and acceleration 
		double xVelocity = sprite.getMyVelocity()*Math.cos(myCurrentLocation.getMyHeading());
		double newXVelocity = xVelocity + spritePhysics.getVerticalGravity()*timeElapsed;
		
		//get initial y velocity component and acceleration
		double yVelocity = sprite.getMyVelocity()*Math.sin(myCurrentLocation.getMyHeading()*timeElapsed);
		double newYVelocity = yVelocity + spritePhysics.getHorizontalGravity();	
		
		sprite.setMyVelocity(Math.sqrt(Math.pow(newXVelocity, 2) + Math.pow(newYVelocity, 2)));
		
		// calculate the new x and y locations
		double myXLocation = curXLoc + newXVelocity*timeElapsed;
		double myYLocation = curYLoc + newYVelocity*timeElapsed;
		
		// update the location of the sprite
//		Location myNewLocation = new Location(myXLocation, myYLocation, Math.asin(newXVelocity/newYVelocity));
		Location myNewLocation = new Location(myXLocation, myYLocation, myCurrentLocation.getMyHeading());
		sprite.setMyLocation(myNewLocation);
	}
	
}
