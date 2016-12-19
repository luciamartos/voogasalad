package game_data.characteristics;

//This entire file is part of my masterpiece.
//James Marlotte

//I have included this file in my masterpiece because I think it shows proper implementation of a couple concepts we have covered in the course.
//The first concept this implements is an interface. Moveable implements the characteristic interface that creates a sort of template for what type of behaviors a certain sprite can have.
//This class also points towards our use of reflection in our annotation system. It is also a pretty clean class without extraneous functionality. 

//@author James

import java.util.Map;
import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_data.sprites.Player;
import game_engine.Side;
import game_engine.actions.Action;
import game_engine.actions.MovableTriggered;

@NameAnnotation(name="Moveable")
public class Movable implements Characteristic{

	private Sprite mySprite;
		
		
	@ParameterAnnotation(parameters= {"Sprite"})
	public Movable(Sprite aSprite){
		mySprite = aSprite;
	}
		
		
	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
			
		Sprite playerSprite = null;
		Side playerCollisionSide = null;
			
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			if(collidedSprite instanceof Player){
				playerSprite = collidedSprite;
				playerCollisionSide = myCollisionMap.get(playerSprite);}
			}

		if (playerSprite != null && playerCollisionSide != null){		
		Action myAction = new MovableTriggered(mySprite, playerSprite, playerCollisionSide);
		myAction.act();
			} 
		}	
		
		
			
	@Override
	public Characteristic copy(Sprite aSprite) {
		return new Movable(aSprite);
	}

}
