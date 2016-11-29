package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

public class LosableByTime extends Losable implements Characteristic{

	private double myTime;
	private Sprite mySprite;
	
	public LosableByTime(double time, Sprite aSprite){
		myTime = time;
		mySprite = aSprite;
	}
	
	public double getTime(){
		return myTime;
	}
	
	public boolean outOfTime(){
		return myTime<=0;
	}
	
	@Override
	public Characteristic copy() {
		return new LosableByTime(myTime, mySprite.clone());
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		//TODO: make and execute action
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//myAction = new ProjectilePowerUp();
			//myAction.act();
		}
	}

}
