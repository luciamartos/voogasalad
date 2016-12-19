package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

public class Enemy extends Character {

	Enemy(Location aLocation, int aWidth, int aHeight, double xVelocity, double yVelocity, String aName, String aImagePath) {
		super(aLocation, aWidth, aHeight, xVelocity, yVelocity, aName, aImagePath);
	}
	
	Enemy(Enemy aEnemy){
		super(aEnemy);
	}
	
	Enemy() {
		super();
	}

	@Override
	public Sprite clone() {
		return new Enemy(this);
	}
	
	public static Enemy buildDefault(){
		return new EnemyDefaultBuilder().buildDefault();
	}

}
