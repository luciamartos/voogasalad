package game_data.states;

import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_data.characteristics.characteristic_annotations.ViewableMethodOutput;

public class Health implements State{

	private int myHealth;
	private boolean isAlive;
	
	@ParameterAnnotation(parameters={"Health"})
	public Health(int health){
		myHealth = health;
	}
	
	@ViewableMethodOutput(type=int.class, description="Health")
	public int getHealth() {
		return myHealth;
	}
	public void setHealth(int health){
		myHealth=health;
	}
	public boolean isAlive(){
		return myHealth>0;
	}
	
	@Override
	public State copy() {
		return new Health(myHealth);
	}
	
	public void kill(){
		myHealth = 0;
	}

	@Override
	public void updateState(double pointsToGive) {
		myHealth-=pointsToGive;
	}

	
}
