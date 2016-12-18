// This entire file is part of my masterpiece
// Austin Gartside
/*
 * This is one of the subclasses of Side. It implements all the necessary methods defined in the super class, which are
 * the different actions. When you compare it with the other side classes you see that the different methods have different
 * implementations. The utility of this is that I don't have to check and see what side is colliding everytime I have a side
 * dependent characteristic. Instead I can just call the method associated with the side, and it will automatically go to
 * the correct class with the correct method. On a more internal level this class is very readable, modularized, and concise
 * which contributes to good internal design.  
 */
package game_engine;
import game_data.Sprite;
import game_data.states.Physics;

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
