package game_engine.actions;

import game_data.Sprite;
import game_engine.Side;

public class MovableTriggered implements Action {
	
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
		// TODO Auto-generated method stub
		if(myMovableCollisionSide.isHorizontal() ){
			myMovableSprite.setXVelocity(myPlayerSprite.getXVelocity());
		}
		if(myMovableCollisionSide.isVertical()){
			myMovableSprite.setYVelocity(myPlayerSprite.getYVelocity());
		}
		
	}

}