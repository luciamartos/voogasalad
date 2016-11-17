/**
 * 
 */
package author.model.game_observables.observable_level;

import java.util.Collection;
import java.util.HashSet;

import game_data.Level;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class ObservableLevel extends Level implements Observable{
	Collection<InvalidationListener> invalidationListeners = new HashSet<>();
	
	/**
	 * @param aSprite
	 */
	ObservableLevel(int width, int height, String backgroundImageFilePath) {
		super(width, height, backgroundImageFilePath);
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		notifyListeners();
	}

	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		notifyListeners();
	}

	@Override
	public void setBackgroundImageFilePath(String backgroundImageFilePath){
		super.setBackgroundImageFilePath(backgroundImageFilePath);
		notifyListeners();
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#addListener(javafx.beans.InvalidationListener)
	 */
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
