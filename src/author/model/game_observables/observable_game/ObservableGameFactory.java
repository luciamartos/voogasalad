/**
 * 
 */
package author.model.game_observables.observable_game;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class ObservableGameFactory {

	/**
	 * 
	 */
	public ObservableGameFactory() {
		// Empty On Purpose
	}
	
	public IObservableGame create(){
		return new ConcreteObservableGame();
	}

}
