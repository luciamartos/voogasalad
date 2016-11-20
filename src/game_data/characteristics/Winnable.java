package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_engine.actions.Bounce;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
public class Winnable implements Characteristic{

	@Override
	public Characteristic copy() {
		return new Winnable();
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		//TODO: make and execute win action
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//myAction = new Bounce();
			//myAction.act();
		}
	}


}
