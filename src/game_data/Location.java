package game_data;

/**
 * Holds X and Y location of a Sprite
 * 
 * @author Addison
 */
public class Location {
	
	private int myXLocation;
	private int myYLocation;
	
	public Location(int myXLocation, int myYLocation){
		setLocation(myXLocation, myYLocation);
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
