package game_data.sprites;
import game_data.Location;
import game_data.Sprite;

public class Item extends Sprite{

	Item(Location aLocation, int aWidth, int aHeight, double xVelocity, double yVelocity, String aName, String aImagePath) {
		super(aLocation, aWidth, aHeight, xVelocity, yVelocity, aName, aImagePath);
	}
	
	Item(Item aItem){
		super(aItem);
	}
	
	Item() {
		super();
	}

	@Override
	public Sprite clone() {
		return new Item(this);
	}
	
	public static Item buildDefault(){
		return new ItemDefaultBuilder().buildDefault();
	}	

}
