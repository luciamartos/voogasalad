package game_engine;

import game_data.Sprite;
import game_data.states.Physics;
/**
 * @author austingartside
 *
 */
public class Bottom extends Side{

	public Bottom() {
		
	}
	
	@Override
	public void bounce(Sprite aSprite, double speed){
		aSprite.setYVelocity(speed);
	}
	
	@Override
	public void hitImpassable(Sprite aSprite){
		Physics aSpritePhysics = getPhysics(aSprite);
		if(aSprite.getYVelocity()<0){
			aSprite.setYVelocity(0);
		}
		if(aSpritePhysics != null && aSpritePhysics.getVerticalGravity()<0){
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
		if(aSprite.getYVelocity()<=0 ){
			if(aSprite.getYVelocity()==0){
				aSprite.setYVelocity(-1*MOVE_SPEED);
			}
			movableSprite.getLocation().setLocation(movableSprite.getLocation().getXLocation(),
					movableSprite.getLocation().getYLocation()+(aSprite.getYVelocity()/FRAMES_PER_SECOND));
			aSprite.setYVelocity(0);	}
		
	}

}
