// This entire file is part of my masterpiece
// Katrina Zhu
package game_engine.actions;

import game_data.Level;
import game_data.Sprite;
/**
 * The LaunchSkeletonHorizontal class instantiates a Launch object without a level
 * @author Katrina Zhu
 *
 */
public class LaunchSkeletonHorizontal implements Launch{
	private Sprite myLauncher;
	private Sprite myProjectile;
	private double myVelocity;
	
	/**
	  * This constructor builds a launch object without a level.
	  */
	public LaunchSkeletonHorizontal(Sprite myLauncher, Sprite myProjectile, double myVelocity){
		this.myLauncher=myLauncher;
		this.myProjectile=myProjectile.clone();
		this.myVelocity=myVelocity;
	}

	@Override
	public void act() {
		return;
	}
	public LaunchWithLevelHorizontal createLaunchWithLevel(Level aLevel){
		return new LaunchWithLevelHorizontal(myLauncher, myProjectile, myVelocity, aLevel);
	}

	@Override
	public double getVelocity() {
		return myVelocity;
	}

	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new LaunchSkeletonHorizontal(aSprite, myProjectile, myVelocity);
	}


}
