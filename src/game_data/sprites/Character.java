package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

public class Character extends Sprite {

	public Character(Location aLocation, String aImagePath) {
		super(aLocation, aImagePath);
	}

	public Character(Character aCharacter) {
		super(aCharacter);
	}

	@Override
	public Sprite clone() {
		return new Character(this);
	}

}
