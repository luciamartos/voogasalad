package game_data.sprites;
import game_data.Location;
import game_data.Sprite;

public class Terrain extends Sprite{

	public Terrain(Location aLocation, String aImagePath) {
		super(aLocation, aImagePath);
	}
	
	public Terrain(Terrain aTerrain){
		super(aTerrain);
	}

	@Override
	public Sprite clone() {
		return new Terrain(this);
	}

}
