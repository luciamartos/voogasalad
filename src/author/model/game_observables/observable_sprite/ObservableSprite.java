/**
 * 
 */
package author.model.game_observables.observable_sprite;

import java.util.Collection;
import java.util.HashSet;

import game_data.Sprite;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class ObservableSprite extends Sprite implements Observable{
	Collection<InvalidationListener> invalidationListeners = new HashSet<>();
	
	/**
	 * @param aSprite
	 */
	ObservableSprite(Sprite aSprite) {
		super(aSprite);
	}
	
	
	@Override
	public void setMyImagePath(String myImagePath) {
		super.setMyImagePath(myImagePath);
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
