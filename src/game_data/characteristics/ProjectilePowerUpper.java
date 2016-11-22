package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.CharacteristicAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */

@CharacteristicAnnotation(name = "Projectile Power Up")
public class ProjectilePowerUpper extends PowerUpper implements Characteristic{

	@ParameterAnnotation(parameters = {"Sprite"})
	public ProjectilePowerUpper(Sprite aSprite){
		super(aSprite);
		//nothing? unless we want to have different projectile types
		//make your character a launcher
	}
	
	@Override
	public Characteristic copy() {
		return new ProjectilePowerUpper(mySprite);
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
