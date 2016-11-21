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
		myDistance = distance;
		mySprite = associatedSprite;
		originalXPosition = associatedSprite.getMyLocation().getXLocation();
		originalYPosition = associatedSprite.getMyLocation().getYLocation();
	}
	
	public PacerAlternative(Sprite associatedSprite){
		myType = "";
		myDistance = 0;
		mySprite = associatedSprite;
		originalXPosition = associatedSprite.getMyLocation().getXLocation();
		originalYPosition = associatedSprite.getMyLocation().getYLocation();
	}
	
	private boolean changeDirection(){
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
		if(changeDirection()){
			//execute action
		}
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//execute action
		}
	}

}
