// This entire file is a part of my masterpiece.
// George Bernard
// See SpriteFactory for discussion
package game_data.sprites.builder;

import game_data.Sprite;

/**
 * This functional interface interacts with @SpriteFactory to create default sprites with set characteristics
 * The default subclasses are open to extension
 * @author Jordan Frazier
 *
 */
@FunctionalInterface
public interface SpriteDefaultBuilder{

	static final int WIDTH = 100;
	static final int HEIGHT = 100;
	
	/**
	 * Returns default sprite specified by implementing class
	 * 
	 * @return default sprite
	 */
	public Sprite buildDefault(); 
}
