// This entire file is part of my masterpiece.
// Alex Zaldastani

package game_engine.properties;

public class RandomMoveDisjointHandler extends RandomMoveHandler {

	
	public RandomMoveDisjointHandler(Orientation aOrientation) {
		super(aOrientation);
	}
	
	protected void setSpritesNewLocation() {
		moveMainSprite();
	}
	
	public RandomMoveHandler copy() {
		return new RandomMoveDisjointHandler(getOrientation());
	}
	
	private void moveMainSprite() {
		getSprite().getLocation().setLocation(getNewXLocation(), getNewYLocation());
	}
	
	private double getNewXLocation() {
		if(getOrientation().equals(Orientation.VERTICAL)) {
			return Math.random()*( getScreenWidth() - getSprite().getWidth() );
		} else {
			return getSprite().getLocation().getXLocation() + getScreenWidth() + getSprite().getWidth();
		}
	}
	
	private double getNewYLocation() {
		if(getOrientation().equals(Orientation.VERTICAL)) {
			return getSprite().getLocation().getYLocation() - getScreenHeight() - getSprite().getHeight();
		} else {
			return Math.random()*( getScreenHeight() - getSprite().getHeight() );
		}
	}
	
}
