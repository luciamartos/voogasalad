package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

public abstract class Character extends Sprite {

	public Character(Location aLocation, int aWidth, int aHeight, double xVelocity, double yVelocity, String aName, String aImagePath) {
		super(aLocation, aWidth, aHeight, xVelocity, yVelocity, aName, aImagePath);
	}
	
	public Character(Character aCharacter){
		super(aCharacter);
	}
	
	public Character() {
		super();
	}

}
