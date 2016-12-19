package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

public class Terrain extends Sprite {

	Terrain(Location aLocation, int aWidth, int aHeight, double xVelocity, double yVelocity, String aName, String aImagePath) {
		super(aLocation, aWidth, aHeight, xVelocity, yVelocity, aName, aImagePath);
	}

	Terrain(Terrain aTerrain) {
		super(aTerrain);
	}

	Terrain() {
		super();
	}

	@Override
	public Sprite clone() {
		return new Terrain(this);
	}

	public static Sprite buildDefault() {
		return new TerrainDefaultBuilder().buildDefault();
	}
	
	

}
