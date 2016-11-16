package author.model.presets;

import author.model.game_observables.observable_sprite.ObservableSprite;

/**
 * 
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class SpritePreset implements ISpritePreset{
	private ObservableSprite sprite;
	
	public SpritePreset(ObservableSprite aObservableSprite) {
		this.sprite = aObservableSprite;
	}
	
	/* (non-Javadoc)
	 * @see author.model.presets.ISpritePreset#getSprite()
	 */
	@Override
	public ObservableSprite getSprite() {
		return this.sprite;
	}


}
