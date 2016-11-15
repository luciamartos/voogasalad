package author.model.presets;

import author.model.game_observables.ObservableSprite;

public class SpritePresetFactory {

	public SpritePresetFactory() {
		// TODO Nothing, On Purpose
	}

	public ISpritePreset create(ObservableSprite aObservableSprite){
		return new ConcreteSpritePreset(aObservableSprite);
	}
	
}
