package game_engine.actions;

import game_data.Level;
import game_data.Sprite;
/**
 * @author Katrina
 *
 */
public class LaunchWithLevelVertical implements Launch{
	private Sprite myLauncher;
	private Sprite myProjectile;
	private double myVelocity;
	private Level myLevel;
	public LaunchWithLevelVertical(Sprite myLauncher, Sprite myProjectile, double myVelocity, Level myLevel){
		this.myLauncher=myLauncher;
		this.myVelocity=myVelocity;
		this.myLevel=myLevel;
		this.myProjectile=myProjectile;
	}

	@Override
	public void act() {
		boolean up=true;
		myProjectile=myProjectile.clone();
		if(myLauncher.getYVelocity()>0){
			up=false;
		}
		if(up){
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()+myLauncher.getWidth()/2, myLauncher.getLocation().getYLocation()-20);
			myProjectile.setYVelocity(-myVelocity);
		}
		else{
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()+myLauncher.getWidth()/2, myLauncher.getLocation().getYLocation() + myLauncher.getHeight()+20);
			myProjectile.setYVelocity(myVelocity);
		}
		myProjectile.setXVelocity(0);
		myLevel.addNewSprite(myProjectile);		
	}

	@Override
	public double getVelocity() {
		return myVelocity;
	}
	
	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new LaunchWithLevelVertical(aSprite, myProjectile, myVelocity, myLevel);
	}



}
