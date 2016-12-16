// This entire file is part of my masterpiece.
// Katrina Zhu
package game_engine.actions;

import game_data.Level;
import game_data.Sprite;
/**
 * This class is a Launch object with a Level.
 * This code is the launch object that the backend is using.  It's good design because
 * it can be seamlessly created with the LaunchProxy and it's hidden from the front end,
 * so the front end does not need to know what level the action is being set in.
 * @author Katrina Zhu
 */
public class LaunchWithLevelHorizontal implements Launch{
	private Sprite myLauncher;
	private Sprite myProjectile;
	private double myVelocity;
	private Level myLevel;
	private static final int SHIFT_CONSTANT=20;
	/**
	 * This constructor sets the launcher sprite, the projectile, the velocity, and the level.
	 */
	public LaunchWithLevelHorizontal(Sprite myLauncher, Sprite myProjectile, double myVelocity, Level myLevel){
		this.myLauncher=myLauncher;
		this.myVelocity=myVelocity;
		this.myLevel=myLevel;
		this.myProjectile=myProjectile;
	}

	@Override
	public void act() {
		myProjectile=myProjectile.clone();
		boolean right=true;
		if(myLauncher.getXVelocity()<0){
			right=false;
		}
		if(right){
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()+myLauncher.getWidth()+SHIFT_CONSTANT, 
					myLauncher.getLocation().getYLocation()+myLauncher.getHeight()/2);
			myProjectile.setXVelocity(myVelocity);
		}
		else{
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()-SHIFT_CONSTANT, 
					myLauncher.getLocation().getYLocation() + myLauncher.getHeight()/2);
			myProjectile.setXVelocity(-myVelocity);
		}
		myProjectile.setYVelocity(0);
		myLevel.addNewSprite(myProjectile);		
	}

	@Override
	public double getVelocity() {
		return myVelocity;
	}
	
	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new LaunchWithLevelHorizontal(aSprite, myProjectile, myVelocity, myLevel);
	}



}
