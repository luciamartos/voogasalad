package author.model.presets;

public class SpritePresetFactory {

	public SpritePresetFactory() {
		// TODO Nothing, On Purpose
	}

	public ISpritePreset create(){
		return new ConcreteSpritePreset();
	}
	
}
