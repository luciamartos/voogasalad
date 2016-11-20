package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

/**
 * @author austingartside
 *
 */
public class Item extends Sprite{

	public Item(Location aLocation, String aImagePath, double width, double height) {
		super(aLocation, aImagePath, width, height);
	}
	
	public Item(Item aItem){
		super(aItem);
	}

	@Override
	public Sprite clone() {
		return new Item(this);
	}

}
