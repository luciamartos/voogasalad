/**
 * 
 */
package author.model.game_observables;

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

}
