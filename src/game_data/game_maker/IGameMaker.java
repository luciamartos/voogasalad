/**
 * 
 */
package game_data.game_maker;

import game_data.Game;
import game_data.Level;
import game_data.Location;
import game_data.Sprite;
import game_data.characteristics.Characteristic;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IGameMaker {

	public void makeNewGame();

	public void saveGame();

	public void saveGameAs();

	public Level makeNewLevel(int aWidth, int aHeight, String aBackgroundImageFilePath);

	public Sprite makeNewSprite(String SpriteType, Location aLocation, String aImagePath);
	
	public void cloneSprite(Sprite aSprite);
	
	public Level getActiveLevel();
	
	public void setActiveLevel(Level aLevel);
	
}
