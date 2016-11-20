package game_data.characteristics;

public class LosableOnCollision extends Losable implements Characteristic{

	@Override
	public boolean toAct() {
		//if collision return true, want to subtract health and see if that is less than 0?
		return false;
	}

	@Override
	public Characteristic copy() {
		return new LosableOnCollision();
	}
	

}
