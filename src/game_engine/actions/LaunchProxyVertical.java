
package game_engine.actions;

import game_data.Level;
import game_data.Sprite;
/**
 * LaunchProxyVertical exists to set a launch action without knowing the level.
 * 
 * @author Katrina Zhu
 */
public class LaunchProxyVertical implements LevelSetter, Launch {
	private Launch myLaunch;
	private double myVelocity;
	
	/**
	 * The constructor creates a LaunchSkeleton object without a level and sets the velocity.
	 */
	public LaunchProxyVertical(Sprite myLauncher, Sprite myProjectile, double myVelocity) {
		myLaunch=new LaunchSkeletonVertical(myLauncher, myProjectile, myVelocity);
		this.myVelocity=myVelocity;
	}
	
	@Override
	public void act() {
		myLaunch.act();
	}

	@Override
	public double getVelocity(){
		return myVelocity;
	}
	
	@Override
	public void setLevel(Level aLevel) {
		if(myLaunch instanceof LaunchSkeletonVertical){
			myLaunch=((LaunchSkeletonVertical) myLaunch).createLaunchWithLevel(aLevel);
		}		
	}

	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return myLaunch.copyWithNewSprite(aSprite);
	}

}
