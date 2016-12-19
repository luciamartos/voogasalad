package game_data.characteristics;

import java.util.Map;
import game_engine.Side;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
//import javafx.geometry.Side;

@NameAnnotation(name = "Losable On Collision")
public class LosableOnCollision extends Losable implements Characteristic{

	private Sprite mySprite;
	
	@ParameterAnnotation(parameters={"Sprite"})
	public LosableOnCollision(Sprite aSprite){
		super(aSprite);
		mySprite = aSprite;
	}
	
	@Override
	public Characteristic copy(Sprite aSprite) {
		return new LosableOnCollision(aSprite);
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		//TODO: make and execute action
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			//myAction = new Losable();
			//myAction.act();
		}
		
	}
	

}
