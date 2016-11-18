/**
 * 
 */
package author.model.game_observables.observable_sprite;

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

	/* (non-Javadoc)
	 * @see game_data.Sprite#clone()
	 */
	@Override
	public Sprite clone() {
		// TODO Auto-generated method stub
		return null;
	}	

}
