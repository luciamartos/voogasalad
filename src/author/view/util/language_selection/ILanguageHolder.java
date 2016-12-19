// This entire file is part of my masterpiece.
// Addison Howenstine

/*
 * This simple interface is used to wrap the IAuthorController
 * to allow the Controller to store the currently selected language to
 * be used in the authoring environment. This allows for seamless language
 * changing in the authoring environment so one can edit in any implemented language
 * (currently English and Spanish). I feel that this code and its implementations 
 * shows my ability to use Interfaces and the Observer/Observable pattern to delegate
 * functionality and offer only the necessary methods to different areas of code as can
 * be seen throughout my masterpiece.
 */

package author.view.util.language_selection;

import javafx.beans.Observable;

/**
 * Holds reference to Resource Bundle holding language currently in use.
 * 
 * @author Addison Howenstine
 */
public interface ILanguageHolder extends Observable{
	
	/**
	 * If aLanguage is a known language with a stored 
	 * properties file, the authoring environment will switch
	 * to displaying text in this language
	 * 
	 * @param aLanguage
	 */
	public void setLanguage(String aLanguage);
	
	/** 
	 * For a given key, the Language Holder will look for
	 * the key in the current language's properties file and 
	 * return its display text String
	 * 
	 * @param aKey
	 * @return display text
	 */
	public String getDisplayText(String aKey);
	
	/**
	 * For a given path name key, the Language Holder will
	 * look for the stored path name in the properties file to
	 * pass back to the caller
	 * 
	 * @param aKey
	 * @return a path String
	 */
	public String getPathString(String aKey);
	
}
