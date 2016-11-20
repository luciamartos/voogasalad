package game_data.sprites;
import game_data.Location;
import game_data.Sprite;

/**
 * @author austingartside
 *
 */
public class Terrain extends Sprite{

	public Terrain(Location aLocation, String aImagePath, double width, double height) {
		super(aLocation, aImagePath, width, height);
	}
	
	public Terrain(Terrain aTerrain){
		super(aTerrain);
	}

	@Override
	public Sprite clone() {
		return new Terrain(this);
	}

}
