package game_engine.properties;

import game_data.Sprite;

//this class will be apart of Sprite to handle movement
public class RandomMoveHandler {

	public enum Orientation {
		HORIZONTAL, VERTICAL;
	}
	private Orientation myOrientation;
	private Sprite mySprite;
	private double myScreenWidth, myScreenHeight, myScreenXPosition, myScreenYPosition;
	
	public RandomMoveHandler(Orientation aOrientation) {
		myOrientation = aOrientation;
	}
	
	public RandomMoveHandler(RandomMoveHandler aRandomMoveHandler) {
		if(aRandomMoveHandler!=null){
			myOrientation = aRandomMoveHandler.getMyOrientation();
		}
		else{
			myOrientation = null;
		}
	}
	
	public void move(Sprite aMySprite, double aMyScreenWidth, double aMyScreenHeight, 
			double aMyScreenXPosition, double aMyScreenYPosition) {
		
		mySprite = aMySprite;
		myScreenWidth = aMyScreenWidth;
		myScreenHeight = aMyScreenHeight;
		myScreenXPosition = aMyScreenXPosition*-1; //switch to different coordinates
		myScreenYPosition = aMyScreenYPosition*-1; //switch to different coordinates
		
		if(objectPassed()) {
			setSpritesNewLocation();
		}
		
	}
	
	private boolean objectPassed() {
		if(myOrientation.equals(Orientation.VERTICAL)) {
			return mySprite.getLocation().getYLocation() > myScreenYPosition+myScreenHeight;
		} else {
			return mySprite.getLocation().getXLocation()+mySprite.getWidth() < myScreenXPosition;
		}
	}
	
	private void setSpritesNewLocation() {
		
		double newXLoc, newYLoc;
		if(myOrientation.equals(Orientation.VERTICAL)) {
			newXLoc = Math.random()*myScreenWidth;
			newYLoc = mySprite.getLocation().getYLocation()-myScreenHeight-mySprite.getHeight();
		} else {
			newXLoc = mySprite.getLocation().getXLocation()+myScreenWidth+mySprite.getWidth();
			newYLoc = Math.random()*myScreenHeight;
		}
		mySprite.getLocation().setLocation(newXLoc, newYLoc);
		
	}
	
	public Orientation getMyOrientation() {
		return myOrientation;
	}
	
}
