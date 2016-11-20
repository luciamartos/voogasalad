package game_engine.actions;

import game_data.Sprite;
import game_data.Level;

public class Break implements Action {
	private Sprite myBrokenSprite;
	private Sprite myPlayerSprite;
	private Level myLevel;
	public Break(Sprite aBrokenSprite, Sprite aPlayerSprite, Level aLevel) {
		myBrokenSprite=aBrokenSprite;
		myPlayerSprite=aPlayerSprite;
		myLevel=aLevel;
	}

	@Override
	public void act() {
		myPlayerSprite.setMyVelocity(-myPlayerSprite.getMyVelocity());		
		myLevel.removeSprite(myBrokenSprite);
	}
}
