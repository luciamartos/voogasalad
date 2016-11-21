package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
public class HealthPowerUpper extends PowerUpper implements Characteristic{

	private int myHealthToGain;
	
	public HealthPowerUpper(int healthToGain, Sprite aSprite){
		super(aSprite);
		myHealthToGain = healthToGain;
	}
	
	public int getHealthToGain(){
		return myHealthToGain;
	}
	
	@Override
	public Characteristic copy() {
		return new HealthPowerUpper(myHealthToGain, mySprite);
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//TODO need to make action
			//Action myAction = new Damage(mySprite, collidedSprite);
			//myAction.act();
		}		
	}

}
