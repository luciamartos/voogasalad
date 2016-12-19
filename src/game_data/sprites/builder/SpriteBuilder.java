// This entire file is a part of my masterpiece.
// George Bernard
// See SpriteFactory for discussion

package game_data.sprites.builder;

import game_data.Location;
import game_data.Sprite;

/**
 * Functional Interface for building a sprite with full options.
 * 
 * @author George Bernard
 */
@FunctionalInterface
public interface SpriteBuilder {

		/**
		 * Returns new instance of sprite with given arguments as constructor
		 * operands.
		 * 
		 * @param aLocation  the location of the sprite
		 * @param aWidth 	 the width of the sprite 
		 * @param aHeight	 the heigh of the sprite
		 * @param xVelocity	 the initial xVelocity of the sprite
		 * @param yVelocity  the initial yVelocity of the sprite
		 * @param aName		 the name of the sprite
		 * @param aImagePath the filepath to the image of this sprite
		 * @return a new sprite constructed with the above operands
		 */
		Sprite buildSprite(Location aLocation, int aWidth, int aHeight, double xVelocity, double yVelocity, String aName, String aImagePath);
}
