// This entire file is part of my masterpiece
// Katrina Zhu
package game_engine.actions;

import game_data.Level;
import game_data.Sprite;
/**
 * The LaunchSkeletonHorizontal class instantiates a Launch object without a level.
 * An instance of this class is created in LaunchProxy.  The method createLaunchWithLevel
 * can be called in LaunchProxyHorizontal to seamlessly create an instance of LaunchWithLevelHorizontal
 * that copies LaunchSkeletonHorizontal, but with a level.  This class is good code because 
 * it seamlessly integrates with LaunchProxy and LaunchWithLevelHorizontal.  Additionally, 
 * act() is called without a level, the LaunchSkeleton does nothing, as it should.
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
	
	/**
	  * This method returns a LaunchWithLevel object given the level that one wants to set.
	  */
	public LaunchWithLevelHorizontal createLaunchWithLevel(Level aLevel){
		return new LaunchWithLevelHorizontal(myLauncher, myProjectile, myVelocity, aLevel);
	}
	
	@Override
	public void act() {
		return;
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
