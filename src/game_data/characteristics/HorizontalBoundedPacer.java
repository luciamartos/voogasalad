package game_data.characteristics;

import game_data.Sprite;

public class HorizontalBoundedPacer extends BoundedPacer implements Characteristic{

	public HorizontalBoundedPacer(int speed, double lowerBound, double upperBound) {
		super(speed, lowerBound, upperBound);
	}

	@Override
	public boolean toChangeDirection(Sprite aSprite) {
		double xLocation = aSprite.getMyLocation().getXLocation();
		return xLocation<=this.getLowerBound() || xLocation>=this.getUpperBound();
	}
	
	@Override
	public Characteristic copy() {
		return new HorizontalBoundedPacer(this.getSpeed(), this.getLowerBound(), this.getUpperBound());
	}

}
