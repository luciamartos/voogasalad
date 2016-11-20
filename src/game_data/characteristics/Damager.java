package game_data.characteristics;

/**
 * @author austingartside
 *
 */
public class Damager implements Characteristic{
	
	private int myDamageToGive;
	
	public Damager(int damageToGive){
		myDamageToGive = damageToGive;
	}
	
	public int getDamage(){
		return myDamageToGive;
	}

	@Override
	public boolean toAct() {
		//return isCollision()
		return false;
	}

	@Override
	public Characteristic copy() {
		return new Damager(myDamageToGive);
	}

}
