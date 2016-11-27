package author.model.presets;

import game_data.Sprite;

public class SpritePresetFactory {

	private SpritePresetFactory() {
		// Does Nothing
	}

	public ISpritePreset create(Sprite aObservableSprite){
		return new ConcreteSpritePreset(aObservableSprite);
	}
	
}
