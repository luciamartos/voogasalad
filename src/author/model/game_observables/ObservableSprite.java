/**
 * 
 */
package author.model.game_observables;

import game_data.Sprite;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class ObservableSprite extends Sprite implements IObservableSprite{
	

	/**
	 * @param aSprite
	 */
	ObservableSprite(Sprite aSprite) {
		super(aSprite);
	}
	
	/* (non-Javadoc)
	 * @see javafx.beans.value.ObservableValue#addListener(javafx.beans.value.ChangeListener)
	 */
	@Override
	public void addListener(ChangeListener<? super Sprite> listener) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javafx.beans.value.ObservableValue#getValue()
	 */
	@Override
	public Sprite getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see javafx.beans.value.ObservableValue#removeListener(javafx.beans.value.ChangeListener)
	 */
	@Override
	public void removeListener(ChangeListener<? super Sprite> listener) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#addListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javafx.beans.Observable#removeListener(javafx.beans.InvalidationListener)
	 */
	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

}
