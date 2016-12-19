package game_engine.actions;

//This entire file is part of my masterpiece.
//James Marlotte

//This is the action that the Moveable Characteristic calls through the act method. It also uses interface. It takes in the Moveable sprite, the collsionSide, and the player sprite as Parameters.
//Through act, it calls a method in the side class to actually move the moveable sprite. 

import game_data.Sprite;
import game_engine.Side;

public class MovableTriggered implements Action{
	
	private Sprite myPlayerSprite;
	private Sprite myMovableSprite;
	private Side myMovableCollisionSide;
	


	public MovableTriggered(Sprite MovableSprite, Sprite PlayerSprite, Side CollisionSide){
		myPlayerSprite = PlayerSprite;
		myMovableSprite = MovableSprite;
		myMovableCollisionSide = CollisionSide;	
	}
	
	@Override
	public void act() {
		myMovableCollisionSide.Movable(myPlayerSprite, myMovableSprite);
		}
	
	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return null;
	}
		
}




