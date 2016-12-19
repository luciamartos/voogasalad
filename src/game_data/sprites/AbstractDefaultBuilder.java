package game_data.sprites;

import game_data.Sprite;
import game_data.sprites.builder.SpriteDefaultBuilder;

public abstract class AbstractDefaultBuilder implements SpriteDefaultBuilder {
		
	@Override
	public abstract Sprite buildDefault();

}
