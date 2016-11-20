package game_data;

import java.util.HashSet;
import java.util.Set;

import game_data.characteristics.Characteristic;
import game_engine.SpritePhysics;

/**
 * Represents any viewable object in a Level including
 * characters, items, terrains, projectiles, etc.
 * 
 * @author Addison, Austin
 */
public abstract class Sprite {
	
	private Location myLocation;
	private String myImagePath;
	private double myVelocity;
	private CollisionHandler myCollisionHandler;
	private Set<Characteristic> myCharacteristics;
	private double myWidth;
	private double myHeight;
	
	public Sprite(Location aLocation, String aImagePath, double width, double height){
		myLocation = aLocation;
		myImagePath = aImagePath;
		myVelocity = 0;
		myCollisionHandler = null;
		myCharacteristics = new HashSet<Characteristic>();
		myWidth = width;
		myHeight = height;
	}
	
	//for copying sprites
	public Sprite(Sprite aSprite){
		myLocation = new Location(aSprite.getMyLocation().getXLocation(),
				aSprite.getMyLocation().getYLocation(), aSprite.getMyLocation().getMyHeading());
		myImagePath = aSprite.getMyImagePath();
		myVelocity = aSprite.getMyVelocity();
		myCollisionHandler = null; //to change: would need to have the same collision handler but we don't know what that is yet
		myCharacteristics = copyCharacteristics(this.getCharacteristics());
	}
	
	/**
	 * should return a clone using the new Sprite(this) constructor
	 */
	public abstract Sprite clone();
	
	public Set<Characteristic> copyCharacteristics(Set<Characteristic> origCharacteristics){
		Set<Characteristic> characteristicCopies = new HashSet<Characteristic>();
		for(Characteristic c: origCharacteristics){
			characteristicCopies.add(c.copy());
		}
		return characteristicCopies;	
	}
	
	public Set<Characteristic> getCharacteristics(){
		return myCharacteristics;
	}
	
	public void addCharacteristic(Characteristic aCharacteristic){
		myCharacteristics.add(aCharacteristic);
	}
	
	public Location getMyLocation() {
		return myLocation;
	}
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	public double getMyVelocity() {
		return myVelocity;
	}
	public void setMyVelocity(double myVelocity) {
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
	public SpritePhysics getSpritePhysics() {
		// TODO Auto-generated method stub
		return null;
	}
	public double getMyWidth() {
		return myWidth;
	}

	public void setMyWidth(double myWidth) {
		this.myWidth = myWidth;
	}

	public double getMyHeight() {
		return myHeight;
	}

	public void setMyHeight(double myHeight) {
		this.myHeight = myHeight;
	}
}
