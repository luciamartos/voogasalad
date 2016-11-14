package game_data;

/**
 * Represents any viewable object in a Stage including
 * characters, items, terrains, projectiles, etc.
 * 
 * @author Addison
 */
public abstract class Sprite {
	
	private Location myLocation;
	private String myImagePath;
	private int myVelocity;
	private CollisionHandler myCollisionHandler;
	private int myHeading;
	
	public Sprite(Location aLocation, String aImagePath){
		myLocation = aLocation;
		myImagePath = aImagePath;
		myVelocity = 0;
		myCollisionHandler = null;
		myHeading = 0;
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
	public int getMyHeading() {
		return myHeading;
	}
	public void setMyHeading(int myHeading) {
		this.myHeading = myHeading;
	}
}
