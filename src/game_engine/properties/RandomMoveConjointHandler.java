// This entire file is part of my masterpiece.
// Alex Zaldastani

package game_engine.properties;

import game_data.Sprite;

public class RandomMoveConjointHandler extends RandomMoveHandler {

	private Sprite myConnectedSprite;
	private double myDistanceApart;
	
	public RandomMoveConjointHandler(Sprite aConnectedSprite, Orientation aOrientation, double aDistanceApart) {
		super(aOrientation);
		myConnectedSprite = aConnectedSprite;
		myDistanceApart = aDistanceApart;
	}
	
	protected void setSpritesNewLocation() {
		
		double newMainXLoc = getNewMainXLocation();
		double newMainYLoc = getNewMainYLocation();
		
		getSprite().getLocation().setLocation(newMainXLoc, newMainYLoc);
		
		double newConnectedXLoc = newMainXLoc + getConnectedXOffset();
		double newConnectedYLoc = newMainYLoc + getConnectedYOffset();
		
		getConnectedSprite().getLocation().setLocation(newConnectedXLoc, newConnectedYLoc);
		
	}
	
	private double getNewMainXLocation() {
		if(isVertical()) {
			return Math.random()*(getScreenWidth() - getDistanceApart()) - getSprite().getWidth();
		} else {
			return getSprite().getLocation().getXLocation() + getScreenWidth() + getSprite().getWidth();
		}
	}
	
	private double getNewMainYLocation() {
		if(isVertical()) {
			return getSprite().getLocation().getYLocation() - getScreenHeight() - getSprite().getHeight();
		} else {
			return Math.random()*(getScreenHeight() - getDistanceApart()) - getSprite().getHeight();
		}
	}
	
	private double getConnectedXOffset() {
		if(isVertical()) {
			return getDistanceApart() + getSprite().getWidth();
		} else {
			return 0;
		}
	}

	private double getConnectedYOffset() {
		if(isVertical()) {
			return 0;
		} else {
			return getDistanceApart() + getSprite().getHeight();
		}
	}
	
	private boolean isVertical() {
		return getOrientation().equals(Orientation.VERTICAL);
	}
	
	public RandomMoveHandler copy() {
		return new RandomMoveConjointHandler(myConnectedSprite, getOrientation(), myDistanceApart);
	}
	
	public void setConnectedSprite(Sprite aSprite) {
		myConnectedSprite = aSprite;
	}
	
	public void setDistanceApart(double distance) {
		myDistanceApart = distance;
	}
	
	public Sprite getConnectedSprite() {
		return myConnectedSprite;
	}

	public double getDistanceApart() {
		return myDistanceApart;
	}
	
}
