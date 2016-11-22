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
	Level currentLevel;
	public Game(){
		myLevels = new ArrayList<Level>();
		myXMLSaver = new XMLTranslator();
		currentLevel=myLevels.get(0);
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
	public List<Level> getMyLevels(){
		return myLevels;
	}

	public void setCurrentLevel(int levelNumber) {
		currentLevel=myLevels.get(levelNumber);
		
	}
	public Level getCurrentLevel(){
		return currentLevel;
	}
	public Level goToNextLevel(){
		int current=myLevels.indexOf(currentLevel);
		if(current<myLevels.size()){
			currentLevel=myLevels.get(current+1);
		}
		else{
			//may or may not need to change this code
			currentLevel=myLevels.get(0);
		}
		return currentLevel;
	}

}
