/**
 * 
 */
package author.model.sprite_builder;

import author.model.presets.ISpritePreset;
import game_data.Location;
import game_data.Player;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class SpriteBuilder {

	/**
	 * 
	 */
	public SpriteBuilder(ISpritePreset spritePreset) {
		// Intentionally Empty
	}
	
	public Sprite createSpriteFromPreset(ISpritePreset spritePreset){
		Location newLocation = new Location(spritePreset.getSprite().getMyLocation().getXLocation(), spritePreset.getSprite().getMyLocation().getYLocation(), 0);
		return new Player(newLocation, spritePreset.getSprite().getMyImagePath());	
	}

}
