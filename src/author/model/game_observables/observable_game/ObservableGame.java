/**
 * 
 */
package author.model.game_observables.observable_game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import author.model.game_observables.observable_level.ObservableLevel;
import author.model.game_observables.observable_level.ObservableLevelFactory;
import game_data.Game;
import game_data.Level;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class ObservableGame extends Game implements IObservableGame{
	private Collection<InvalidationListener> invalidationListeners = new HashSet<>();
	private List<ObservableLevel> levels = new ArrayList<>();
	private ObservableLevel currentLevel;
	/**
	 * 
	 */
	public ObservableGame() {
		super();
	}
	
	public ObservableLevel getCurrentLevel(){
		return currentLevel; 
	}
	
	public ObservableLevel newLevel(int width, int height, String backgroundImageFilePath){
		this.currentLevel = new ObservableLevelFactory().create(width, height, backgroundImageFilePath);
		levels.add(this.currentLevel);
		super.addNewLevel(this.currentLevel);
		notifyListeners();
		return this.currentLevel;
	}
	
	public List<ObservableLevel> getLevels(){
		return this.levels;
	}
	
	public Boolean setLevel(ObservableLevel existingLevel){
		if (this.levels.contains(existingLevel)){
			this.currentLevel = existingLevel;
			return true;
		}
		return false;
	}
	
	@Override
	public void addListener(InvalidationListener listener) {
		this.invalidationListeners.add(listener);
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#removeListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void removeListener(InvalidationListener listener) {
		this.invalidationListeners.remove(listener);
	}
	
	private void notifyListeners(){
		this.invalidationListeners.forEach((listener) -> listener.invalidated(this));
	}

}
