/**
 * 
 */
package author.model.game_observables;

import game_data.Location;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 *TODO: Redefine Interface after Sprite settles out/has an interface
 */
class ConcreteObservableSprite extends ObservableSprite{
	

	/**
	 * @param aSprite
	 */
	ConcreteObservableSprite(Sprite aSprite) {
		super(aSprite);
	}
	
	/**
	 * @param aLocation
	 * @param aImagePath
	 */
	public ConcreteObservableSprite(Location aLocation, String aImagePath) {
		super(aLocation, aImagePath);
	}
	
	

}
