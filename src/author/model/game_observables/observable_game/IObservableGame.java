/**
 * 
 */
package author.model.game_observables.observable_game;

import java.util.List;

import author.model.game_observables.observable_level.ObservableLevel;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IObservableGame extends Observable{

	public ObservableLevel getCurrentLevel();
	
	public ObservableLevel newLevel(int width, int height, String backgroundImageFilePath);
	
	public List<ObservableLevel> getLevels();
	
	public Boolean setLevel(ObservableLevel existingLevel);
}
