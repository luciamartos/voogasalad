package game_data;

/**
 * Represents any viewable object in a Level including
 * characters, items, terrains, projectiles, etc.
 * 
 * @author Addison
 */
public abstract class Sprite {
	
	private Location myLocation;
	private String myImagePath;
	private int myVelocity;
	private CollisionHandler myCollisionHandler;
	
	public Sprite(Location aLocation, String aImagePath){
		myLocation = aLocation;
		myImagePath = aImagePath;
		myVelocity = 0;
		myCollisionHandler = null;
	}
	
	//for copying sprites
	public Sprite(Sprite aSprite){
		myLocation = new Location(aSprite.getMyLocation().getXLocation(),
				aSprite.getMyLocation().getYLocation(), aSprite.getMyLocation().getMyHeading());
		myImagePath = aSprite.getMyImagePath();
		myVelocity = aSprite.getMyVelocity();
		myCollisionHandler = null; //to change: would need to have the same collision handler but we don't know what that is yet	
	}
	
	public Location getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	public int getMyVelocity() {
		return myVelocity;
	}
	public void setMyVelocity(int myVelocity) {
		this.myVelocity = myVelocity;
	}
	public String getMyImagePath() {
		return myImagePath;
	}
	public void setMyImagePath(String myImagePath) {
		this.myImagePath = myImagePath;
	}
	public CollisionHandler getMyCollisionHandler() {
		return myCollisionHandler;
	}
	public void setMyCollisionHandler(CollisionHandler myCollisionHandler) {
		this.myCollisionHandler = myCollisionHandler;
	}
}
