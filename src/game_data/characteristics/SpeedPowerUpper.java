

package game_data.characteristics;

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

}