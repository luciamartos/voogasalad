package game_data.characteristics;

public class Health implements Characteristic{

	private int myHealth;
	
	public Health(int health){
		myHealth = health;
	}
	
	public int getHealth(){
		return myHealth;
	}
	
	@Override
	public boolean toAct() {
		//act upon collision? (should be the only way to lose health)
		return true;
	}

	@Override
	public Characteristic copy() {
		return new Health(myHealth);
	}

}
