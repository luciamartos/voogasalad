/**
 * 
 */
package author.model;

import java.io.File;

import game_data.Game;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168), Addison Howenstine
 *
 */
public interface IAuthorModel {
	
	public Sprite addSprite(Sprite aSpritePreset);
	
	public void newGame();
	
	public Game getGame();
	
	public void saveGame(String aFileName);
	
	public void loadGame(File aFile);
}
