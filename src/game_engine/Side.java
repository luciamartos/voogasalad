// This entire file is part of my masterpiece
// Austin Gartside
/*
 * This part of the masterpice is the super class for the Sides. These are returned for collisions and indicate which side 
 * an object is hit on when there is a collision. this is important because there are multiple characteristics that change
 * behavior based on what side they are hit on. Below are some constants that are necessary in calculations, and the methods
 * that need to be implemented differently for each side. Prior to refactoring each action that was side dependent
 * needed a large if tree and an enum to decide what action to carryout. Now all of that information is centralized and 
 * you'll see in the action class as part of the amsterpiece how it works. This class demonstrates the power of inheritance.
 * Internally it has only the minimum necessary information and contains information relevant to the subclasses so it
 * reduces the amount of potential repeated code. 
 */
package game_engine;

import game_data.Sprite;
import game_data.states.Physics;
import game_data.states.State;

public abstract class Side {
	
	public static final double MOVE_SPEED = 100.0;
	public static final int FRAMES_PER_SECOND = 60;
	
	public abstract void bounce(Sprite aSprite, double bounceSpeed);
	public abstract void hitImpassable(Sprite aSprite);
	public abstract boolean isVertical();
	public abstract boolean isHorizontal();
	public abstract void Movable (Sprite aSprite, Sprite movableSprite);
	
	public Physics getPhysics(Sprite aSprite){
		Physics spritePhysics = null;
		for(State s: aSprite.getStates()){
			if(s instanceof Physics){
				spritePhysics = ((Physics)s);
			}
		}
		return spritePhysics;
	}
	
}

