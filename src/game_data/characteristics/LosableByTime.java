package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.CharacteristicAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import javafx.geometry.Side;

@CharacteristicAnnotation(name = "Losable By Time")
public class LosableByTime extends Losable implements Characteristic{

	private double myTime;
	
	@ParameterAnnotation(parameters = {"Time"})
	public LosableByTime(double time){
		myTime = time;
	}
	
	public double getTime(){
		return myTime;
	}
	
	public boolean outOfTime(){
		return myTime<=0;
	}
	
	@Override
	public Characteristic copy() {
		return new LosableByTime(myTime);
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
