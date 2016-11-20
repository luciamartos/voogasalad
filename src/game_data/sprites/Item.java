package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

/**
 * @author austingartside
 *
 */
public class Item extends Sprite{

	public Item(Location aLocation, String aImagePath) {
		super(aLocation, aImagePath);
	}
	
	public Item(Item aItem){
		super(aItem);
	}

	@Override
	public Sprite clone() {
		return new Item(this);
	}

}
