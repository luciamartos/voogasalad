package game_data.characteristics;

/**
 * @author austingartside
 *
 */
public abstract class PowerUpper implements Characteristic{
	
	public PowerUpper(){
		//do nothing?
	}
	
	@Override
	public boolean toAct(){
		//act upon collision
		return false;
	}

}
