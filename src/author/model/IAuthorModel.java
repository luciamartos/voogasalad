/**
 * 
 */
package author.model;

import java.util.List;
import author.model.presets.ISpritePreset;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IAuthorModel {

	public List<ISpritePreset> getPresets();
	
	public void addPreset(Sprite aPresetSprite);
	
	public Sprite addSprite(ISpritePreset spritePreset);
}
