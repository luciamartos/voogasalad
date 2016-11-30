/**
 * 
 */
package game_data;

import java.util.Collection;
import java.util.HashSet;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
abstract class GameObject implements Observable{
	private Collection<InvalidationListener> invalidationListeners = new HashSet<>();
	private String name;

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
	
	protected void notifyListeners(){
		this.invalidationListeners.forEach((listener) -> listener.invalidated(this));
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String aName){
		this.name = aName;
		notifyListeners();
	}

}
