package author.controller;

import java.util.List;

import author.model.AuthorModelFactory;
import author.model.IAuthorModel;
import author.model.game_observables.observable_level.ObservableLevel;
import author.view.AuthorView;
import javafx.scene.Scene;

/**
 * @author George Bernard
 */
public class ConcreteAuthorController implements IAuthorController, IAuthorControllerExternal{

	private IAuthorModel authorModel;
	private AuthorView authorView;
	/* (non-Javadoc)
	 * @see author.controller.IAuthorControllerExternal#getScene()
	 */
	public ConcreteAuthorController() {
		this.authorModel = new AuthorModelFactory().create((IAuthorController) this);
		this.authorView = new AuthorView();
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

}
