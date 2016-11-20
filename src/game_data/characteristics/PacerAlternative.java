package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

public class PacerAlternative implements Characteristic{

	private static final String VERTICAL = "VERTICAL";
	private static final String HORIZONTAL = "HORIZONTAL";
	
	private String myType;
	private double myDistance;
	private double originalXPosition;
	private double originalYPosition;
	private Sprite mySprite;
	
	public PacerAlternative(String type, double distance, Sprite associatedSprite){
		myType = type;
		distance = myDistance;
		mySprite = associatedSprite;
		originalXPosition = associatedSprite.getMyLocation().getXLocation();
		originalYPosition = associatedSprite.getMyLocation().getYLocation();
	}
	
	private boolean directionToChange(){
		if(myType.equals(VERTICAL)){
			return atYBound();
		}
		if(myType.equals(HORIZONTAL)){
			return atXBound();
		}
		return false;
	}
	
	private boolean atYBound(){
		double currentYLocation = mySprite.getMyLocation().getYLocation();
		return currentYLocation<=originalYPosition || currentYLocation>= (originalYPosition+myDistance);			
	}
	
	private boolean atXBound(){
		double currentXLocation = mySprite.getMyLocation().getXLocation();
		return currentXLocation<=originalYPosition || currentXLocation>= (originalXPosition+myDistance);			
	}

	@Override
	public Characteristic copy() {
		return new PacerAlternative(myType, myDistance, mySprite.clone());
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		//TODO: make and execute action
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//myAction = new ProjectilePowerUp();
			//myAction.act();
		}
	}

}
