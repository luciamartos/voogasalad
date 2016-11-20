package game_data.characteristics;

/**
 * @author austingartside
 *
 */
public class Winnable implements Characteristic{

	@Override
	public boolean toAct() {
		//if collision return true
		return true;
	}

	@Override
	public Characteristic copy() {
		return new Winnable();
	}

}
