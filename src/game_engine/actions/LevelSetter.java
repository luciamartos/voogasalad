// This entire file is part of my masterpiece.
// Katrina Zhu
package game_engine.actions;

import game_data.Level;
/**
 * The LevelSetter interface allows a class to set a level.
 * This interface is good code because it easily allows other classes 
 * to check if an object needs to have a level set, and subsequently
 * call setLevel().
 * @author Katrina Zhu
 */
public interface LevelSetter {
	/**
	  * Allows a user to set a level.
	  */
	public void setLevel(Level aLevel);
	
}
