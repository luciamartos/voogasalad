package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

/**
 * @author austingartside
 *
 */
public class Projectile extends Sprite{
	
	Projectile(Location aLocation, int aWidth, int aHeight, double xVelocity, double yVelocity, String aName, String aImagePath) {
		super(aLocation, aWidth, aHeight, xVelocity, yVelocity, aName, aImagePath);
	}
	
	Projectile(Projectile aProjectile){
		super(aProjectile);
	}
	
	Projectile() {
		super();
	}

	@Override
	public Sprite clone() {
		return new Projectile(this);
	}

	public static Projectile buildDefault() {
		return new ProjectileDefaultBuilder().buildDefault();
	}
	
}
