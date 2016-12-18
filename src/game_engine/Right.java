package game_engine;

import game_data.Sprite;
import game_data.states.Physics;
/**
 * @author austingartside
 *
 */
public class Right extends Side{

	public Right() {
	}
	
	@Override
	public void bounce(Sprite aSprite, double speed){
		aSprite.setXVelocity(speed);
	}
	
	@Override
	public void hitImpassable(Sprite aSprite){
		Physics aSpritePhysics = getPhysics(aSprite);
		if(aSprite.getXVelocity()<0){
			aSprite.setXVelocity(0);
		}
		if(aSpritePhysics != null && aSpritePhysics.getHorizontalGravity()<0){
			aSprite.setXAcceleration(-aSpritePhysics.getHorizontalGravity());
		}
	}
	
	@Override
	public boolean isVertical() {
		return false;
	}

	@Override
	public boolean isHorizontal() {
		return true;
	}

	@Override
	public void Movable(Sprite aSprite, Sprite movableSprite) {
		if(aSprite.getXVelocity()<=0){
			if(aSprite.getXVelocity()==0){
				aSprite.setXVelocity(-1*MOVE_SPEED);
			}
			movableSprite.getLocation().setLocation(movableSprite.getLocation().getXLocation()
					+(aSprite.getXVelocity()/FRAMES_PER_SECOND), movableSprite.getLocation().getYLocation());
			aSprite.setXVelocity(0);
		}		
	}
}
