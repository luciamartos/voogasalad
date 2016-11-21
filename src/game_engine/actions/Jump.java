package game_engine.actions;

import game_data.Sprite;

public class Jump implements Action {
	private Sprite mySprite;
	private double myJumpingVelocity;
	public Jump(Sprite aSprite, double aJumpingVelocity) {
		mySprite=aSprite;
		myJumpingVelocity=aJumpingVelocity;
	}

	@Override
	public void act() {
		//the below casting should not exist once velocity is changed in sprite
		mySprite.setMyVelocity((int)myJumpingVelocity);
		MoveUp moveUp=new MoveUp(mySprite, mySprite.getMyVelocity());
		moveUp.act();
	}

}
