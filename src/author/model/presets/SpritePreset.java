package author.model.presets;

import game_data.Sprite;

/**
 * 
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class SpritePreset implements ISpritePreset{
	private Sprite sprite;
	
	public SpritePreset(Sprite aSprite) {
		this.sprite = aSprite;
	}
	
	/* (non-Javadoc)
	 * @see author.model.presets.ISpritePreset#getSprite()
	 */
	@Override
	public Sprite getSprite() {
		return this.sprite;
	}


}
