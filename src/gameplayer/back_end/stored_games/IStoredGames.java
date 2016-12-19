
// This entire file is part of my masterpiece.
// Ted Marchildon

/*
 * Defines the API for stored games
 */

package gameplayer.back_end.stored_games;

import java.io.File;
import java.util.List;

public interface IStoredGames {
	
	public File getGameFilePath(String aGamename);
	
	public List<String> getGames();

	public List<String> getIcons();
	
	public List<String> getDescriptions();
	
}
