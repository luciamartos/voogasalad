package game_engine;

import game_data.Sprite;
import game_data.states.Physics;

/**
 * @author austingartside
 *
 */
public class Top extends Side{
	
	@Override
	public void bounce(Sprite aSprite, double bounceSpeed){
		aSprite.setYVelocity(-bounceSpeed);
	}
	
	@Override
	public void hitImpassable(Sprite aSprite){
		Physics aSpritePhysics = getPhysics(aSprite);
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
			aSprite.setYAcceleration(getPhysics(aSprite).getVerticalGravity());
			aSprite.setYVelocity(0);
			movableSprite.setYAcceleration(getPhysics(aSprite).getVerticalGravity());				
		}
	}
}
