/**
 * 
 */
package author.model.game_observables;

import java.util.Collection;
import java.util.HashSet;

import game_data.Sprite;
import javafx.beans.InvalidationListener;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class ObservableSprite extends Sprite implements IObservableSprite{
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
		invalidationListeners.forEach((listener) -> listener.invalidated(this));
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#addListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void addListener(InvalidationListener listener) {
		invalidationListeners.add(listener);
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#removeListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void removeListener(InvalidationListener listener) {
		invalidationListeners.remove(listener);
	}

}
