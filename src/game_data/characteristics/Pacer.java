/*
 * Author: Alex and Austin
 * 
 * if toAct() is true run the following:
 * getSpeed()
 * 
 */

package game_data.characteristics;

import game_data.Sprite;

public abstract class Pacer {
	
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
	
	public abstract boolean toChangeDirection(Sprite aSprite);

}
