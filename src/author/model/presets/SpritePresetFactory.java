package author.model.presets;

import game_data.Sprite;

public class SpritePresetFactory {

	public SpritePresetFactory() {
		// TODO Nothing, On Purpose
	}

	public ISpritePreset create(Sprite aObservableSprite){
		return new ConcreteSpritePreset(aObservableSprite);
	}
	
}
