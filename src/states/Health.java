package states;

public class Health implements State{

	private int myHealth;
	private String myName;
	private boolean isAlive;
	
	public Health(int health, String name){
		myHealth = health;
		isAlive = true;
		myName = name;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	@Override
	public State copy() {
		return new Health(myHealth, myName);
	}
	
	private void kill(){
		isAlive = false;
	}

	@Override
	public void updateState() {
		myHealth--;
	}
	
}
