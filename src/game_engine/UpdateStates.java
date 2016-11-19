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
import game_engine.actions.Jump;
import game_engine.actions.MoveLeft;
import game_engine.actions.MoveRight;
import javafx.geometry.Side;
import javafx.scene.input.KeyCode;

/**
 * TODO make sure that player doesnt run into walls or thigns 
 * NOTE: doing the runKeyCalls and then updating sprite posistions separately might lead to an issue with glitches
 * CHECK: CALCULATING HEARDING FROM THE VERTICAL (NOON) CHECK CORRECT CALC FOR VEL
 * QUESTION who is going to keep track of the time of the game? how are we going to provoke a win? through interface?
 * TODO give myLevel all the properties I want.
 * TODO sprite needs to give me to image view.
 * CLARIFY: does the x and y loc represent the middle or the left top corner or what?
 * There are some things that I dont know if I should be getting from level class of the engine itself
 * Losses should actually probably be integrated within characteristics so we dont check for collision repeatedly.
 * Do we have to deal with if the sprite hits a block at multiple sides?
 * 
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
		
		generateDefaultKeyMap();
		executeCharacteristics();
		runKeyCalls();
		updateSpritePositions();
		checkForWin();
		checkForLoss();
	}

	//keys will only control the main player rn
	private void generateDefaultKeyMap() {
		myKeyMap.put(KeyCode.RIGHT, new MoveRight(enginePlayerController.getMyLevel().getMainPlayer(), GameResources.MOVE_RIGHT_SPEED.getResource()));
		myKeyMap.put(KeyCode.LEFT, new MoveLeft(enginePlayerController.getMyLevel().getMainPlayer(), GameResources.MOVE_LEFT_SPEED.getResource()));
		myKeyMap.put(KeyCode.UP, new Jump(enginePlayerController.getMyLevel().getMainPlayer(), GameResources.JUMP_SPEED.getResource()));		
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

	// not the best design in the world but works for the time being
	private void checkForWin() {
		Set<String> type = enginePlayerController.getMyLevel().getWinType();
		if(type.contains("time")&& enginePlayerController.getMyLevel().getTime() > enginePlayerController.getMyLevel().getTimeToWin()){
			System.out.print("YOU WIN");
		}
		
		if(type.contains("score") && enginePlayerController.getMyLevel().getMainPlayerSprite().getPoints() > enginePlaterController.getMyLevel().getPointsToWin()){
			System.out.println("YOU WIN");
		}
		
		if(type.contains("object") && enginePlayerController.getMyLevel().getWinningSprite().getBoundsInLocal().interects(enginePlayerController.getMyLevel().getMainPlayerSprite())){
			System.out.println("YOU WIN");
		}
	}
	
	private void checkForLoss() {
		Set<String> type = enginePlayerController.getMyLevel().getLossType();
		Sprite mainPlayer = enginePlayerController.getMainPlayer();
		if(type.contains("object")){
			List<Sprite> deathProvokingObj = enginePlayerController.getMyOjbectSpriteList();
			for(Sprite myObj : deathProvokingObj){
				if(myObj.getImageView().getBoundsInLocal().interects(mainPlayer.getImageView().getBoundsInLocal())){
					System.out.println("DEATH");
				}
			}
		}
	}

	private void updateSpritePositions() {
		for(Sprite sprite:mySpriteList){
			updateSpritePosition(sprite);
		}	
	}

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
