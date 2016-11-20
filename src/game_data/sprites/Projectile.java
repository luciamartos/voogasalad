package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

/**
 * @author austingartside
 *
 */
public class Projectile extends Sprite{
	
	public Projectile(Location aLocation, String aImagePath) {
		super(aLocation, aImagePath);
	}
	
	public Projectile(Projectile aProjectile){
		super(aProjectile);
	}

	@Override
	public Sprite clone() {
		return new Projectile(this);
	}

}
