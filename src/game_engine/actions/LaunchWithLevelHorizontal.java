// This entire file is part of my masterpiece.
// Katrina Zhu
package game_engine.actions;

import game_data.Level;
import game_data.Sprite;
/**
 * This class is a Launch object with a Level.
 * @author Katrina Zhu
 */
public class LaunchWithLevelHorizontal implements Launch{
	private Sprite myLauncher;
	private Sprite myProjectile;
	private double myVelocity;
	private Level myLevel;
	
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
		boolean right=true;
		myProjectile=myProjectile.clone();
		if(myLauncher.getXVelocity()<0){
			right=false;
		}
		if(right){
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()+myLauncher.getWidth()+20, myLauncher.getLocation().getYLocation()+myLauncher.getHeight()/2);
			myProjectile.setXVelocity(myVelocity);
		}
		else{
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()-20, myLauncher.getLocation().getYLocation() + myLauncher.getHeight()/2);
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
