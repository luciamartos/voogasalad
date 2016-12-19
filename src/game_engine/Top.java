package game_engine;

//This entire file is part of my masterpiece.
//James Marlotte

//This class extends the Abstract "side" class. I have included it in my masterpiece to show how the Moveable Sprite is actually affected by the Moveable characteristic and action when the player collides on the top side.
//The movable method is called from the MoveableTriggered action class to avoid the use of if trees and nested for loops in figuring out how to move the object after a collision.
//The Moveable characteristic instead deals directly with a method in the collision side of the moveable object to reset the player's velocity and give the moveable object a downwards acceleration after a player jumps on it. 

import game_data.Sprite;
import game_data.states.Physics;
import game_data.states.State;

public class Top extends Side{

	public Top() {
	}
	
	@Override
	public void bounce(Sprite aSprite, double bounceSpeed){
		aSprite.setYVelocity(-bounceSpeed);
	}
	@Override
	public boolean breaksOnSide(boolean isBreakable){
		return isBreakable;
	}
	
	@Override
	public void hitImpassable(Sprite aSprite, Physics aSpritePhysics){
		if(aSprite.getYVelocity()>0){
			aSprite.setYVelocity(0);
		}
		if( aSpritePhysics != null &&  aSpritePhysics.getVerticalGravity()>0){
			aSprite.setYAcceleration(-aSpritePhysics.getVerticalGravity());
		}
	}

	@Override
	public boolean isVertical() {
		return true;
	}

	@Override
	public boolean isHorizontal() {
		return false;
	}

	@Override
	public void Movable(Sprite aSprite, Sprite movableSprite) {
		
		if(aSprite.getYVelocity()>=0 ){
			for(State i : aSprite.getStates()){
				if(i instanceof Physics){
					aSprite.setYAcceleration(-((Physics)i).getVerticalGravity());
					aSprite.setYVelocity(0);
					movableSprite.setYAcceleration(((Physics)i).getVerticalGravity());
					
				}
			}

		}
	}
}
