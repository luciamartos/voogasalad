package game_engine;

public abstract class SpritePhysics {
		
	private double downAcceleration;
	private double upAcceleration;
	private double leftAcceleration;
	private double rightAcceleration;
	private double initVelocity;
	
	
	public SpritePhysics(double downAcceleration, double upAcceleration, double leftAcceleration, double rightAcceleration, double initVelocity) {
		this.downAcceleration = downAcceleration;
	}
	
	public SpritePhysics(){
		this.downAcceleration = GameResources.NORMAL_GRAVITY.getDoubleResource();
		
	}
	
	//nothing fed in - normal physics
	//just acceleration 
	//
	
	
	

}
