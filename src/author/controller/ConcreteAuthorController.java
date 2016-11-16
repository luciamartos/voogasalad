package author.controller;

import java.util.List;

import author.model.AuthorModelFactory;
import author.model.IAuthorModel;
import author.model.game_observables.observable_game.IObservableGame;
import author.model.game_observables.observable_game.ObservableGameFactory;
import author.model.game_observables.observable_level.ObservableLevel;
import author.view.AuthorView;
import javafx.scene.Scene;

/**
 * @author George Bernard
 */
public class ConcreteAuthorController implements IAuthorController, IAuthorControllerExternal{

	private IAuthorModel authorModel;
	private AuthorView authorView;
	private IObservableGame currentGame;
	/* (non-Javadoc)
	 * @see author.controller.IAuthorControllerExternal#getScene()
	 */
	public ConcreteAuthorController() {
		this.authorModel = new AuthorModelFactory().create((IAuthorController) this);
		this.authorView = new AuthorView();
		this.currentGame = new ObservableGameFactory().create();
	}
	
	@Override
	public Scene getScene() {
		return this.authorView.getScene();
	}

	/* (non-Javadoc)
	 * @see author.controller.IAuthorController#getModel()
	 */
	@Override
	public IAuthorModel getModel() {
		return this.authorModel;
	}

	/* (non-Javadoc)
	 * @see author.controller.IAuthorController#getCurrentGame()
	 */
	@Override
	public IObservableGame getCurrentGame() {
		return this.currentGame;
	}

}
