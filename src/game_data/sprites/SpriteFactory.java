package game_data.sprites;

import game_data.Location;
import game_data.Sprite;

@FunctionalInterface
abstract interface SpriteBuilder{
	/**
	 * Returns new instance of sprite with given arguments as constructor operands.
	 * 
	 * @param aLocation
	 * @param aFilePath
	 * @return new instance of sprite
	 */
	Sprite buildSprite(Location aLocation, String aImagePath);
}

/**
 * Sprite factory
 * 
 * @author George Bernard
 */
public enum SpriteFactory implements SpriteBuilder {
	//PLAYER(		(loc, path) -> { return new Player(loc, path);}),
	ENEMY(		(loc, path) -> { return null;} ),
	TERRAIN(	(loc, path) -> { return null;} ),
	ITEM(		(loc, path) -> { return null;} ),
	PROJECTILE(	(loc, path) -> { return null;} );
	
	private SpriteBuilder myBuilder;	
	private SpriteFactory(SpriteBuilder SpriteMaker){
		myBuilder = SpriteMaker;
	}
	
	@Override
	public Sprite buildSprite(Location aLocation, String aFilePath) {
		return myBuilder.buildSprite(aLocation, aFilePath);
	}
	
	
	
}
