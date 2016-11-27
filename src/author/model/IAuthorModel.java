/**
 * 
 */
package author.model;

import java.util.List;

import author.model.presets.ISpritePreset;
import author.model.sprite_builder.SpriteBuilder;
import game_data.Game;
import game_data.Level;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IAuthorModel {
	
	public Sprite addSprite(Sprite aSpritePreset);
	
	public void newGame();
	
	public Game getGame();
}
