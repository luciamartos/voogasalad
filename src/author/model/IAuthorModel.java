/**
 * 
 */
package author.model;

import java.util.List;

import author.model.presets.ISpritePreset;
import game_data.Level;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IAuthorModel {

	public void newGame();

	public void saveGameAs(String aGameFilePath, String aGameFileName);
	
	public Level addLevel(int aWidth, int aHeight, String aBackgroundImageFilePath);	
	
	public Sprite addSprite(ISpritePreset spritePreset);

	public void addPreset(Sprite aPresetSprite);
	
	public void setActiveLevel(Level aLevel);
	
	public List<ISpritePreset> getPresets();
	
	public List<Level> getLevels();
}
