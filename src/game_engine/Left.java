package game_engine;

import game_data.Sprite;

public class Left extends Side{

	public Left() {
	}
	
	@Override
	public void bounce(Sprite aSprite, double speed){
		aSprite.setMyXVelocity(-speed);
	}
	
	@Override
	public boolean breaksOnSide(boolean isBreakable){
		return isBreakable;
	}
	
	@Override
	public void hitImpassable(Sprite aSprite, SpritePhysics aSpritePhysics){
		if(aSprite.getMyXVelocity()>0){
			aSprite.setMyXVelocity(0);
		}
		if(aSpritePhysics.getHorizontalGravity()>0){
			aSprite.setMyXAcceleration(-aSpritePhysics.getHorizontalGravity());
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

}
