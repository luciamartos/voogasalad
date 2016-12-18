package game_engine;

import game_data.Sprite;
import game_data.states.Physics;
import game_data.states.State;


/**
 * @author austingartside
 *
 */
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

