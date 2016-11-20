package game_data.characteristics;

import game_data.Sprite;

public class VerticalBoundedPacer extends BoundedPacer implements Characteristic{

	public VerticalBoundedPacer(int speed, double lowerBound, double upperBound) {
		super(speed, lowerBound, upperBound);
	}

	@Override
	public boolean toChangeDirection(Sprite aSprite) {
		double yLocation = aSprite.getMyLocation().getYLocation();
		return yLocation<=this.getLowerBound() || yLocation>=this.getUpperBound();
	}
	
	@Override
	public Characteristic copy() {
		return new VerticalBoundedPacer(this.getSpeed(), this.getLowerBound(), this.getUpperBound());
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}

}
