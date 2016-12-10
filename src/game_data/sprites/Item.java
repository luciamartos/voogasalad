package game_data.sprites;
import game_data.Location;
import game_data.Sprite;

public class Item extends Sprite{

	public Item(Location aLocation, int aWidth, int aHeight, double xVelocity, double yVelocity, String aName, String aImagePath) {
		super(aLocation, aWidth, aHeight, xVelocity, yVelocity, aName, aImagePath);
	}
	
	public Item(Item aItem){
		super(aItem);
	}
	
	public Item() {
		super();
	}

	@Override
	public Sprite clone() {
		return new Item(this);
	}

}
