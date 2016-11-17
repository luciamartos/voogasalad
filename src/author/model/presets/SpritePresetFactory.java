package author.model.presets;

import author.model.game_observables.observable_sprite.ObservableSprite;

public class SpritePresetFactory {

	public SpritePresetFactory() {
		// TODO Nothing, On Purpose
	}

	public ISpritePreset create(ObservableSprite aObservableSprite){
		return new ConcreteSpritePreset(aObservableSprite);
	}
	
}
