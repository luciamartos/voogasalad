package game_data;

import java.util.HashSet;
import java.util.Set;
import states.State;
import game_data.characteristics.Characteristic;

/**
 * Represents any viewable object in a Level including
 * characters, items, terrains, projectiles, etc.
 * 
 * @author Addison, Austin
 */
public abstract class Sprite {
	
	private Location myLocation;
	private int myWidth;
	private int myHeight;
	private String myName;
	private String myImagePath;
	private double myVelocity;
	private CollisionHandler myCollisionHandler;
	private Set<Characteristic> myCharacteristics;
	private Set<State> myStates;
	
	public Sprite(Location aLocation, int aWidth, int aHeight, String aName, String aImagePath){
		myLocation = aLocation;
		myWidth = aWidth;
		myHeight = aHeight;
		myName = aName;
		myImagePath = aImagePath;
		myVelocity = 0;
		myCollisionHandler = new CollisionHandler();
		myCharacteristics = new HashSet<Characteristic>();
		myStates = new HashSet<State>();
	}
	
	//for copying sprites
	public Sprite(Sprite aSprite){
		myLocation = new Location(aSprite.getMyLocation().getXLocation(),
				aSprite.getMyLocation().getYLocation(), aSprite.getMyLocation().getMyHeading());
		myWidth = aSprite.getMyWidth();
		myHeight = aSprite.getMyHeight();
		myName = aSprite.getMyName();
		myImagePath = aSprite.getMyImagePath();
		myVelocity = aSprite.getMyVelocity();
		myCollisionHandler = aSprite.getMyCollisionHandler(); //to change: would need to have the same collision handler but we don't know what that is yet
		myCharacteristics = copyCharacteristics(aSprite.getCharacteristics());
		myStates = copyStates(aSprite.getStates());
	}
	
	/**
	 * should return a clone using the new Sprite(this) constructor
	 */
	public abstract Sprite clone();
	
	private Set<Characteristic> copyCharacteristics(Set<Characteristic> aCharacteristicSet){
		if (aCharacteristicSet == null)
			return null;
		Set<Characteristic> characteristicCopies = new HashSet<Characteristic>();
		for(Characteristic c: aCharacteristicSet){
			characteristicCopies.add(c.copy());
		}
		return characteristicCopies;	
	}
	
	private Set<State> copyStates(Set<State> aStateSet){
		if (aStateSet == null)
			return null;
		Set<State> stateCopies = new HashSet<State>();
		for(State c: aStateSet){
			stateCopies.add(c.copy());
		}
		return stateCopies;	
	}
	
	public Set<Characteristic> getCharacteristics(){
		return myCharacteristics;
	}
	
	public void addCharacteristic(Characteristic aCharacteristic){
		myCharacteristics.add(aCharacteristic);
	}
	
	public Set<State> getStates(){
		return myStates;
	}
	
	public void addState(State aState){
		myStates.add(aState);
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

	public int getMyWidth() {
		return myWidth;
	}

	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
	}

	public int getMyHeight() {
		return myHeight;
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

}