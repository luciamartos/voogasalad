package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_engine.actions.Action;
import game_engine.actions.Break;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
public class Damager implements Characteristic{
	
	private int myDamageToGive;
	private Sprite mySprite;
	
	public Damager(int damageToGive, Sprite aSprite){
		myDamageToGive = damageToGive;
		mySprite = aSprite;
	}
	
	public int getDamage(){
		return myDamageToGive;
	}

	@Override
	public Characteristic copy() {
		return new Damager(myDamageToGive, mySprite);
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//TODO need to make action
			//Action myAction = new Damage(mySprite, collidedSprite);
			//myAction.act();
		}
	}

}
