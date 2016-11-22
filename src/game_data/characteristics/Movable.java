package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

public class Movable implements Characteristic{

	Sprite mySprite;
	
	public Movable(Sprite aSprite){
		mySprite = aSprite;
	}
	
	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		
	}

	@Override
	public Characteristic copy() {
		return new Movable(mySprite.clone());
	}

}
