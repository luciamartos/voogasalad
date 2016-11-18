package game_data.characteristics;

public class Bouncer implements Characteristic{
	
	private double myBounceSpeed;
	
	public Bouncer(double bounceSpeed){
		myBounceSpeed = bounceSpeed;
	}
	
	public double getBounceSpeed(){
		return myBounceSpeed;
	}

	@Override
	public boolean toAct() {
		//return isCollision()
		return false;
	}

	@Override
	public Characteristic copy() {
		return new Bouncer(myBounceSpeed);
	}

}
