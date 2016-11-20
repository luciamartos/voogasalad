

package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
public class SpeedPowerUpper extends PowerUpper implements Characteristic{
	
	private double mySpeedBoost;
	private double myTimeInEffect;
	
	public SpeedPowerUpper(double speedBoost, double timeInEffect){
		mySpeedBoost = speedBoost;
		myTimeInEffect = timeInEffect;
	}
	
	public double getSpeedBoost(){
		return mySpeedBoost;
	}

	@Override
	public Characteristic copy() {
		return new SpeedPowerUpper(mySpeedBoost, myTimeInEffect);
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		//TODO: make and execute speed Up action
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//myAction = new SpeedBoost();
			//myAction.act();
		}
	}

}