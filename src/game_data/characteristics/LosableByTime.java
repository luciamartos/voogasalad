package game_data.characteristics;

import java.util.Map;
import game_engine.Side;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_data.characteristics.characteristic_annotations.ViewableMethodOutput;
//import javafx.geometry.Side;

@NameAnnotation(name = "Losable By Time")
public class LosableByTime extends Losable implements Characteristic{

	private double myTime;
	private Sprite mySprite;
	
	@ParameterAnnotation(parameters = {"Time", "Sprite"})
	public LosableByTime(double time, Sprite aSprite){
		super(aSprite);
		myTime = time;
		mySprite = aSprite;
	}
	
	@ViewableMethodOutput(type=double.class, description="Time")
	public double getTime(){
		return myTime;
	}
	
	public boolean outOfTime(){
		return myTime<=0;
	}
	
	@Override
	public Characteristic copy(Sprite aSprite) {
		return new LosableByTime(myTime, aSprite);
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
