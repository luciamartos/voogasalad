package game_data.characteristics;

import game_data.Sprite;

public class CollisionPacer extends Pacer implements Characteristic{

	public CollisionPacer(int speed) {
		super(speed);
	}

	@Override
	public boolean toChangeDirection(Sprite aSprite) {
		//return isColliding();??? how are we gonna know if there's a collision
		return false;
	}
	
	@Override
	public Characteristic copy() {
		return new CollisionPacer(this.getSpeed());
	}

}
