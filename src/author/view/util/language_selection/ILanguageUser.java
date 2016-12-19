// This entire file is part of my masterpiece.
// Addison Howenstine

/*
 * This simple interface can be implemented by any authoring environment window
 * that displays text. It allows the class to implement an Observer/Observable 
 * pattern in a clearly dependent way showing its use for language changing. If
 * "invalidated" is declared by the observable, different windows may handle this
 * in different ways such as rebuilding menus or replacing text with the new language.
 */

package author.view.util.language_selection;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * Wrapper for any class representing a window or field
 * that displays readable text
 * 
 * @author Addison
 */
public interface ILanguageUser extends InvalidationListener {
	
	/**
	 * Declares that the language of choice has been changed
	 * so text displays should be updated
	 */
	public void invalidated(Observable arg0);

}
