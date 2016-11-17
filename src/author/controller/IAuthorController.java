/**
 * 
 */
package author.controller;

import author.model.IAuthorModel;
import author.model.game_observables.observable_game.IObservableGame;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IAuthorController {

	public IAuthorModel getModel();
	
	public IObservableGame getCurrentGame();
}
