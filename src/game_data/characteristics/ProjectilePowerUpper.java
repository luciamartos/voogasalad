package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
public class ProjectilePowerUpper extends PowerUpper implements Characteristic{

	public ProjectilePowerUpper(){
		//nothing? unless we want to have different projectile types
		//make your character a launcher
	}
	
	@Override
	public Characteristic copy() {
		return new ProjectilePowerUpper();
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		//TODO: make and execute action
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//myAction = new ProjectilePowerUp();
			//myAction.act();
		}
	}

}
