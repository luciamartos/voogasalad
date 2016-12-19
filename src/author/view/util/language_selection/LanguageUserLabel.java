// This entire file is part of my masterpiece.
// Addison Howenstine

/*
 * This short class shows how I used ILanguageUser to wrap a Controller
 * so the Controller could be passed to a Label without passing specific
 * Controller functionality. Though simple, this class also shows how
 * much I learned this semester about keeping code clean by extracting
 * duplication and functionality into one place. This LanguageUserLabel
 * can be used to replace any Label in the authoring environment such that
 * another class only needs to have a pointer to a Label and does not need
 * to know it is tied to a LanguageHolder which will update the displayed 
 * text whenever the language is changed. These principles seem so simple now,
 * but looking back to my code from the beginning of the class, principles like
 * this would never have occurred to me before and I'm proud of the progress
 * I've made to now consider this commonplace.
 */

package author.view.util.language_selection;

import javafx.beans.Observable;
import javafx.scene.control.Label;

/**
 * An implementation of the JavaFX Label that will automatically
 * update its display text when its ILanguageHolder declares that
 * the language in use has been changed.
 *  
 * @author Addison Howenstine
 */
public class LanguageUserLabel extends Label implements ILanguageUser {
	
	private String myKey;
	private ILanguageHolder myLanguageHolder;
	
	public LanguageUserLabel(String aKey, ILanguageHolder aLanguageHolder) {
		myKey = aKey;
		myLanguageHolder = aLanguageHolder;
		myLanguageHolder.addListener(this);
		setText();
	}
	
	@Override
	public void invalidated(Observable arg0) {
		setText();
	}

	private void setText() {
		this.setText(myLanguageHolder.getDisplayText(myKey));
	}
}
