package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

public class Player extends Character {

	public Player(Location aLocation, int aWidth, int aHeight, String aName, String aImagePath) {
		super(aLocation, aWidth, aHeight, aName, aImagePath);
	}
	
	public Player(Player aPlayer){
		super(aPlayer);
	}

	@Override
	public Sprite clone() {
		return new Player(this);
	}

}
