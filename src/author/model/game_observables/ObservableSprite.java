/**
 * 
 */
package author.model.game_observables;

import java.util.HashSet;
import java.util.Set;

import game_data.Location;
import game_data.Sprite;
import javafx.beans.InvalidationListener;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class ObservableSprite extends Sprite implements IObservableSprite{
	private Set<InvalidationListener> listeners = new HashSet<>();
	/**
	 * @param aSprite
	 */
	public ObservableSprite(Sprite aSprite) {
		super(aSprite);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param aLocation
	 * @param aImagePath
	 */
	public ObservableSprite(Location aLocation, String aImagePath) {
		super(aLocation, aImagePath);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	@Override
	public void setMyImagePath(String myImagePath) {
		super.setMyImagePath(myImagePath);
		this.listeners.forEach((listener) -> listener.notify());
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#addListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void addListener(InvalidationListener aListener) {
		this.listeners.add(aListener);
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#removeListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void removeListener(InvalidationListener aListener) {
		this.listeners.remove(aListener);		
	}
}
