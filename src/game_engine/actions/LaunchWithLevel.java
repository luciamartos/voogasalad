package game_engine.actions;

import game_data.Controllable;
import game_data.Level;
import game_data.LevelSetter;
import game_data.Sprite;
import game_data.states.Health;
import game_data.states.State;
/**
 * @author Katrina
 *
 */
public class LaunchWithLevel implements Launch{
	private Sprite myLauncher;
	private Sprite myProjectile;
	private double myVelocity;
	private Level myLevel;
	public LaunchWithLevel(Sprite myLauncher, Sprite myProjectile, double myVelocity, Level myLevel){
		this.myLauncher=myLauncher;
		myProjectile.setXAcceleration(0);
		myProjectile.setYAcceleration(0);
		myProjectile.setControllable(new Controllable());
		//this.myProjectile=myProjectile.clone();
		this.myProjectile=myProjectile;
		this.myVelocity=myVelocity;
		this.myLevel=myLevel;
	}

	@Override
	public void act() {
		for(State s: myProjectile.getStates()){
			if(s instanceof Health){
				((Health)s).setHealth(1);
			}
		}
		boolean right=true;
		//myProjectile=myProjectile.clone();
		//myProjectile=myProjectile
		double myXVelocity=0;
		double myYVelocity=0;
		double velocityAngle=0;
		if(myLauncher.getXVelocity()<0){
			right=false;
		}
		
/*		System.out.println(myLauncher.getName());
		System.out.println(myLauncher.getLocation().getXLocation());
		System.out.println(myLauncher.getLocation().getYLocation());*/
		if(right){
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()+myLauncher.getWidth()+10, myLauncher.getLocation().getYLocation()+myLauncher.getHeight()/2);
		}
		else{
			myProjectile.getLocation().setLocation(myLauncher.getLocation().getXLocation()-10, myLauncher.getLocation().getYLocation() + myLauncher.getHeight()/2);
		}
		if(myLauncher.getXVelocity()==0 && myLauncher.getYVelocity()==0){
			myXVelocity=myVelocity;
			myYVelocity=0;
		}
		else if(myLauncher.getXVelocity()==0){
			myXVelocity=0;
			myYVelocity=myLauncher.getYVelocity();
		}
		else{
			velocityAngle = Math.atan(myLauncher.getYVelocity()/myLauncher.getXVelocity());	
			myXVelocity=Math.signum(myLauncher.getXVelocity())*myVelocity*Math.cos(velocityAngle);
			myYVelocity = Math.signum(myLauncher.getYVelocity())*myVelocity*Math.sin(velocityAngle);
		}
		myProjectile.setXVelocity(myXVelocity);
		myProjectile.setYVelocity(myYVelocity);
		myLevel.addNewSprite(myProjectile);		
	}

	@Override
	public double getVelocity() {
		return myVelocity;
	}
	
	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new LaunchWithLevel(aSprite, myProjectile, myVelocity, myLevel);
	}



}
