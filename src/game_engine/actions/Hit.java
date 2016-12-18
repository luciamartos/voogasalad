package game_engine.actions;

import game_data.Sprite;
import game_engine.Side;

/**
 * @author Austin
 *
 */

public class Hit implements Action {
	
	private Sprite myPlayerSprite;
	private Sprite myNonPlayerSprite;
	private Side mySide;
	

	public Hit(Sprite player,  Side aSide, Sprite nonPlayerSprite) {
		myPlayerSprite = player;
		myNonPlayerSprite = nonPlayerSprite;
		mySide = aSide;
	}
	
	@Override
	public void act() {
		mySide.hitImpassable(myPlayerSprite);
	}

	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new Hit(aSprite, mySide, myNonPlayerSprite);
	}
		
}