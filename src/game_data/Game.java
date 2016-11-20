package game_data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.XMLTranslator;

/**
 * A Game has a List of Levels. Each Level may contain Sprites
 * and other elements. A Game can be saved to a serialized XML
 * file to be loaded elsewhere.
 * 
 * @author Addison
 *
 */
public class Game {
	
	List<Level> myLevels;
	XMLTranslator myXMLSaver;
	
	public Game(){
		myLevels = new ArrayList<Level>();
		myXMLSaver = new XMLTranslator();
	}

	/**
	 * Saves Game, Levels, and all states to a serialized XML File
	 * 
	 * @param filePath
	 * @param fileName
	 * @author Addison
	 */
	public void saveGameAs(String aFilePath, String aFileName){
	    myXMLSaver.saveToFile(this, aFilePath, aFileName);
	}

	public void addNewLevel(Level aLevel){
		myLevels.add(aLevel);
	}

}
