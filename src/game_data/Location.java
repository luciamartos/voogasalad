package game_data;

/**
 * Holds X and Y location of a Sprite
 * 
 * @author Addison
 */
public class Location {

	private int myHeading;
	private int myXLocation;
	private int myYLocation;
	
	public Location(int aXLocation, int aYLocation, int aHeading){
		setLocation(aXLocation, aYLocation);
		setMyHeading(aHeading);
	}
	
	public int getMyHeading() {
		return myHeading;
	}

	public void setMyHeading(int myHeading) {
		this.myHeading = myHeading%360;
	}
	
	public int getXLocation(){
		return myXLocation;
	}
	
	public int getYLocation(){
		return myYLocation;
	}
	
	public void setLocation(int myXLocation, int myYLocation){
		this.myXLocation = myXLocation;
		this.myYLocation = myYLocation;
	}

}
