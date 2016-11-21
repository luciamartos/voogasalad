package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
public class Rotatable implements Characteristic{

	private double mySpeed;
	
	public Rotatable(double speed){
		mySpeed = speed;
	}
	
	public double getSpeed(){
		return mySpeed;
	}

	@Override
	public Characteristic copy() {
		return new Rotatable(mySpeed);
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {		
		//TODO: make and execute rotate action
		//myAction = new Bounce();
		//myAction.act();
	}

}
