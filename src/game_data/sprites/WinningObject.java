package game_data.sprites;

import game_data.Location;
import game_data.Sprite;
/**
 * @author austingartside
 *
 */
public class WinningObject extends Sprite{

	public WinningObject(Location aLocation, String aImagePath, double width, double height) {
		super(aLocation, aImagePath, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public WinningObject(WinningObject aWinningObject){
		super(aWinningObject);
	}

	@Override
	public Sprite clone() {
		return new WinningObject(this);
	}

}
