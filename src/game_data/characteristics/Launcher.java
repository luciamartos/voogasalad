/*
 * Author: Alex
 * 
 * if toAct() is true run the following:
 * getLaunched()
 * 
 */

package game_data.characteristics;

import game_data.*;

public class Launcher {
	
	private Sprite myLaunched;
	private int myTimeInterval;
	private int myCurrentTime;
	
	public Launcher(Sprite launched, int timeInterval) {
		myLaunched = launched;
		myTimeInterval = timeInterval;
		myCurrentTime = 0;
	}
	
	public boolean toAct() {
		myCurrentTime++;
		myCurrentTime %= myTimeInterval;
		return myCurrentTime == 0;
	}
	
	public Sprite getLaunched() {
		
		return myLaunched;
		
	}
	

}
