/**
 * 
 */
package author.model.game_observables.observable_level;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class ObservableLevelFactory {

	/**
	 * 
	 */
	public ObservableLevelFactory() {
		// Empty On purpose
	}

	public ObservableLevel create(int width, int height, String backgroundImageFilePath){
		return new ConcreteObservableLevel(width, height, backgroundImageFilePath);
	}
}
