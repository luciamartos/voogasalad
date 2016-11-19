/**
 * 
 */
package author.model.sprite_builder;

import author.model.presets.ISpritePreset;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class SpriteBuilder {

	/**
	 * 
	 */
	public SpriteBuilder() {
		// Intentionally Empty
	}
	
	public Sprite createSpriteFromPreset(ISpritePreset spritePreset){
		return spritePreset.getSprite().clone();	
	}

}
