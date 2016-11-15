/**
 * 
 */
package author.model.game_observables;

import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class ObservableSpriteFactory {

	/**
	 * 
	 */
	public ObservableSpriteFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public ObservableSprite create(Sprite aSprite){
		return new ConcreteObservableSprite(aSprite);
	}

}
