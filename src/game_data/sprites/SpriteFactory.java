// This entire file is part of my masterpiece
// George Bernard (ghb5)
/*
 * This class is included as my masterpiece as it combines several 
 * advanced java features to accomplish a simple goal in a very succinct and
 * readable way.
 * 
 * The goal is to split apart the concrete instantiation of an object from the interface.
 * This is a pretty standard goal and is basically a solved problem the factory pattern.
 * But the way factory (and especially AbstractFactory) classes are traditionally made is
 * often pretty kludgy, with large if trees or some reflection (built upon hordes of try 
 * catch statements).
 * 
 * What this class does is combine an enumerated type and Java 8 Functional principles.
 * First, we use an enumerated type to ensure that this class can never be instantiated by 
 * any malicious actors. This combined with the class specific privacy of the sprites allows
 * anyone outside of this package to never directly instantiate a sprite. Ensuring encapsulation.
 * 
 * Second we use two functional interfaces: one for building with full customization and one 
 * for defaults. One is as simple as the :: operator to access the sprite constructor the other is 
 * a delgation call to the default builder. This allows us to take advantage of one more quality of 
 * the enum. Anyone who would like to instantiate any of these classes can simply call 
 * SpriteFactory.SUBCLASS.build( _args ) and get the exact subclass they want. Adding a new subclass 
 * is thus much easier than searching for the if tree and adding another two lines.  
 *  
 */
package game_data.sprites;

import game_data.Location;
import game_data.Sprite;
import game_data.sprites.builder.SpriteBuilder;
import game_data.sprites.builder.SpriteDefaultBuilder;

/**
 *  
 * @author George Bernard (ghb5), Addison Howenstine (awh55)
 */
public enum SpriteFactory implements SpriteBuilder, SpriteDefaultBuilder {
	/**
	 * PlayerFactory
	 */
	PLAYER( Player::new, Player::buildDefault ),
	/**
	 * EnemyFactory
	 */
	ENEMY( Enemy::new, Enemy::buildDefault ),	
	/**
	 * TerrainFactory
	 */
	TERRAIN( Terrain::new , Terrain::buildDefault ),
	/**
	 * Item Factory
	 */
	ITEM( Item::new , Item::buildDefault ),
	/**
	 * ProjectileFactory
	 */
	PROJECTILE( Projectile::new , Projectile::buildDefault );

	private SpriteBuilder myBuilder;
	private SpriteDefaultBuilder myDefaultBuilder;

	private SpriteFactory(SpriteBuilder SpriteMaker, SpriteDefaultBuilder aSpriteDefaultBuilder) {
		myBuilder = SpriteMaker;
		myDefaultBuilder = aSpriteDefaultBuilder;
	}
	
	@Override
	public Sprite buildSprite(Location aLocation, int aWidth, int aHeight, double XVelocity, double yVelocity, String aName, String aFilePath) {
		return myBuilder.buildSprite(aLocation, aHeight, aHeight, XVelocity, yVelocity, aName, aFilePath);
	}

	@Override
	public Sprite buildDefault() {
		return myDefaultBuilder.buildDefault();
	}

}
