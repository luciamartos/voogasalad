// This entire file is part of my masterpiece.
// Katrina Zhu
package game_engine.actions;

import game_data.Sprite;

/**
 * The action interface can be implemented to execute actions of sprites.
 * @author Katrina Zhu
 */
public interface Action {
	/**
	  * This method executes the action.
	  */
	public void act();
	
	/**
	  * This method copies the action into a new sprite.
	  */
	public Action copyWithNewSprite(Sprite aSprite);
}
