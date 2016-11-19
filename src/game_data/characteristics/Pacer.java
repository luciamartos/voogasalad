/*
 * Author: Alex
 * 
 * if toAct() is true run the following:
 * getSpeed()
 * 
 */

package game_data.characteristics;

public class Pacer {
	
	private int mySpeed;
	
	public Pacer(int speed) {
		mySpeed = speed;
	}
	
	public boolean toAct() {
		return true;
	}
	
	public int getSpeed() {
		return mySpeed;
	}

}
