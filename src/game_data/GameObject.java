// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)

/* 
 * This class is the top level entity for all of the game_data back end objects.
 * As seen below, I made the design decision for all of these to implement Observable so that
 * I could make use of the Observer design pattern. I chose the Observer design pattern 
 * to avoid creating dependencies between the authoring front end and game back end objects,
 * routing all of the front end updates through this framework. This both ensured that
 * any changes in the front end were represented in the back end (which would ultimately be
 * serialized and sent to the engine and player) and allowed us to develop the authoring
 * environment modularly. A sprite could be edited in the sprite editor, for example,
 * and since this change would notify all listeners to the Sprite Object, Sprites in the
 * Level Editor would immediately reflect this change.
 */

package game_data;

import java.util.Collection;
import java.util.HashSet;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class GameObject implements Observable{
	
	@XStreamOmitField
	private Collection<InvalidationListener> invalidationListeners = new HashSet<>();
	
	private String name;

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#addListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void addListener(InvalidationListener listener) {
		if (this.invalidationListeners == null)
			this.invalidationListeners = new HashSet<>();
		
		this.invalidationListeners.add(listener);
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#removeListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void removeListener(InvalidationListener listener) {
		if (this.invalidationListeners == null)
			this.invalidationListeners = new HashSet<>();
		
		this.invalidationListeners.remove(listener);
	}
	
	protected void notifyListeners(){
		if (this.invalidationListeners == null)
			this.invalidationListeners = new HashSet<>();
			
		this.invalidationListeners.forEach((listener) -> {
			if (listener!=null)
				listener.invalidated(this);
		});
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String aName){
		this.name = aName;
		notifyListeners();
	}

}
