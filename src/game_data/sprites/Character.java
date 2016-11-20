package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

public class Character extends Sprite {
	private int myHealth;
	private boolean myIsAlive;
	public Character(Location aLocation, String aImagePath, int aHealth, double width, double height) {
		super(aLocation, aImagePath, width, height);
		myIsAlive=true;
	}

	public Character(Character aCharacter) {
		super(aCharacter);
	}

	@Override
	public Sprite clone() {
		return new Character(this);
	}
	public int getMyHealth(){
		return myHealth;
	}
	public void setMyHealth(int aHealth){
		myHealth+=aHealth;
		updateIsAlive();
	}
	public boolean isAlive(){
		return myIsAlive;
	}
	private void updateIsAlive(){
		if(myHealth<=0){
			myIsAlive=false;
		}
	}
}
