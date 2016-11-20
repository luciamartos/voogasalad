package game_data.characteristics;

/**
 * @author austingartside
 *
 */
public class HealthPowerUpper extends PowerUpper implements Characteristic{

	private int myHealthToGain;
	
	public HealthPowerUpper(int healthToGain){
		healthToGain = myHealthToGain;
	}
	
	public int getHealthToGain(){
		return myHealthToGain;
	}
	
	@Override
	public Characteristic copy() {
		return new HealthPowerUpper(myHealthToGain);
	}

}
