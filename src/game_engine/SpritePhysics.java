package game_engine;

/**
 * 
 * @author LuciaMartos
 *
 */
public class SpritePhysics {
	//environment
	private double verticalGravity;
	private double horizontalGravity;

	// acceleration
	private double downAcceleration;
	private double upAcceleration;
	private double leftAcceleration;
	private double rightAcceleration;

	// velocity
	private double initDownVelocity;
	private double initUpVelocity;
	private double initLeftVelocity;
	private double initRightVelocity;		
	
	//all parameters are specified
	public SpritePhysics(double verticalGravity, double horizontalGravity,  double downAcceleration, double upAcceleration, double leftAcceleration,
			double rightAcceleration, double initDownVelocity, double initUpVelocity, double initLeftVelocity,
			double initRightVelocity) {
		this.verticalGravity = verticalGravity;
		this.horizontalGravity =horizontalGravity;
		
		this.downAcceleration = downAcceleration;
		this.upAcceleration = upAcceleration;
		this.leftAcceleration = leftAcceleration;
		this.rightAcceleration = rightAcceleration;

		this.initDownVelocity = initDownVelocity;
		this.initLeftVelocity = initLeftVelocity;
		this.initRightVelocity = initRightVelocity;
		this.initUpVelocity = initUpVelocity;
	}

	//default settings "normal physics"
	public SpritePhysics() {
		setDefaults();
	}
	
	//change gravity
	public SpritePhysics(double verticalGravity){
		setDefaults();
		this.verticalGravity = verticalGravity;
	}
	
	public SpritePhysics(double verticalGravity, double horizontalGravity){
		setDefaults();
		this.verticalGravity = verticalGravity;
		this.horizontalGravity = horizontalGravity;
	}
	
	//change gravity and velocities up right left
	public SpritePhysics(double verticalGravity, double horizontalGravity, double initDownVelocity, double initUpVelocity, double initRightVelocity, double initLeftVelocity){
		setDefaults();
		this.verticalGravity = verticalGravity;
		this.horizontalGravity =horizontalGravity;
		this.initDownVelocity = initDownVelocity;
		this.initUpVelocity = initUpVelocity;
		this.initLeftVelocity = initLeftVelocity;
		this.initRightVelocity = initRightVelocity;
	}

	
	private void setDefaults() {
		this.verticalGravity = GameResources.DEFAULT_VERTICAL_GRAVITY.getDoubleResource();
		this.horizontalGravity = GameResources.DEFAULT_HORIZONTAL_GRAVITY.getDoubleResource();
	
		this.downAcceleration = GameResources.DEFAULT_DOWN_ACCELERATION.getDoubleResource();
		this.upAcceleration = GameResources.DEFAULT_UP_ACCELERATION.getDoubleResource();
		this.leftAcceleration = GameResources.DEFAULT_LEFT_ACCELERATION.getDoubleResource();
		this.rightAcceleration = GameResources.DEFAULT_RIGHT_ACCELERATION.getDoubleResource();
		
		this.initDownVelocity = GameResources.DEFAULT_DOWN_VELOCITY.getDoubleResource();
		this.initLeftVelocity = GameResources.DEFAULT_LEFT_VELOCITY.getDoubleResource();
		this.initRightVelocity = GameResources.DEFAULT_RIGHT_VELOCITY.getDoubleResource();
		this.initUpVelocity = GameResources.DEFAULT_UP_VELOCITY.getDoubleResource();
	}

	public double getVerticalGravity(){
		return verticalGravity;
	}
	
	public double getHorizontalGravity(){
		return horizontalGravity;
	}
	
	public double getDownAcceleration() {
		return downAcceleration;
	}

	public double getUpAcceleration() {
		return upAcceleration;
	}

	public double getLeftAcceleration() {
		return leftAcceleration;
	}

	public double getRightAcceleration() {
		return rightAcceleration;
	}

	public double getInitDownVelocity() {
		return initDownVelocity;
	}

	public double getInitUpVelocity() {
		return initUpVelocity;
	}

	public double getInitLeftVelocity() {
		return initLeftVelocity;
	}

	public double getInitRightVelocity() {
		return initRightVelocity;
	}

}
