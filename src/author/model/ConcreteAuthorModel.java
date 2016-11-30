package author.model;

import author.controller.IAuthorController;
import javafx.beans.InvalidationListener;

/**
 * 
 * @author Cleveland Thompson V (ct168)
 *
 */
class ConcreteAuthorModel extends AuthorModel{

	ConcreteAuthorModel(IAuthorController aAuthorController) {
		super(aAuthorController);
	}

}
