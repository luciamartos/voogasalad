package game_data.characteristics;

import java.util.HashMap;

import game_data.Sprite;
import game_engine.actions.Action;
import game_engine.actions.Bounce;
import game_engine.actions.Break;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
public class Bouncer implements Characteristic{
	
	private double myBounceSpeed;
	private Sprite mySprite;
	private Action myAction;
	
	public Bouncer(double bounceSpeed, Sprite mySprite){
		myBounceSpeed = bounceSpeed;
	}
	
	public double getBounceSpeed(){
		return myBounceSpeed;
	}

	@Override
	public boolean toAct() {
		//return isCollision()
		return false;
	}
	
	public void execute(HashMap<Sprite, Side> myCollisionMap){
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//is going to need to have arguments after implemented
			myAction = new Bounce();
			myAction.act();
		}
	}

	@Override
	public Characteristic copy() {
		return new Bouncer(myBounceSpeed, mySprite);
	}

}
