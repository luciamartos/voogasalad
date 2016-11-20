package game_data.characteristics;

/**
 * @author austingartside
 *
 */
public class Rotatable implements Characteristic{

	private double mySpeed;
	
	public Rotatable(double speed){
		mySpeed = speed;
	}
	
	public double getSpeed(){
		return mySpeed;
	}
	
	@Override
	public boolean toAct() {
		return true;
	}

	@Override
	public Characteristic copy() {
		return new Rotatable(mySpeed);
	}

}
