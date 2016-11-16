/**
 * 
 */
package author.controller;

import java.util.List;

import author.model.IAuthorModel;
import author.model.game_observables.observable_game.IObservableGame;
import author.model.game_observables.observable_level.ObservableLevel;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IAuthorController {

	public IAuthorModel getModel();
	
	public IObservableGame getCurrentGame();
}
