package game_data;

/**
 * Holds X and Y location of a Sprite
 * 
 * @author Addison
 */
public class Location {
	
	private double myXLocation;
	private double myYLocation;
	
	public Location(double myXLocation2, double myYLocation2){
		setLocation(myXLocation2, myYLocation2);
	}
	
	public double getXLocation(){
		return myXLocation;
	}
	
	public double getYLocation(){
		return myYLocation;
	}
	
	public void setLocation(double myXLocation2, double myYLocation2){
		this.myXLocation = myXLocation2;
		this.myYLocation = myYLocation2;
	}

}
