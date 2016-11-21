package game_data.characteristics;

import game_data.Sprite;

public abstract class BoundedPacer extends Pacer{

	private double myLowerBound;
	private double myUpperBound;
	
	public BoundedPacer(int speed, double lowerBound, double upperBound) {
		super(speed);
		myLowerBound = lowerBound;
		myUpperBound = upperBound;
	}
	
	public double getLowerBound(){
		return myLowerBound;
	}
	
	public double getUpperBound(){
		return myUpperBound;
	}

}
