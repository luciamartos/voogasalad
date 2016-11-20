package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

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

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		// TODO Auto-generated method stub
		
	}

}
