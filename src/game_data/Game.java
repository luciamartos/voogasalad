package game_data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A Game has a List of Stages. Each Stage may contain Sprites
 * and other elements. A Game can be saved to a serialized XML
 * file to be loaded elsewhere.
 * 
 * @author Addison
 *
 */
public class Game {
	
	List<Stage> myStages;
	
	public Game(){
		myStages = new ArrayList<Stage>();
	}

	/**
	 * Saves Game, Stages, and all states to a serialized XML File
	 * 
	 * @param filePath
	 * @param fileName
	 * @author Addison
	 */
	public void saveGameAs(String filePath, String fileName){
	    java.io.FileWriter fw;
		try {
			fw = new java.io.FileWriter(filePath + fileName + ".xml");
		    fw.write(((new GameSaver()).serialize(this)));
		    fw.close();
		} catch (IOException e) {
			System.out.println("Trouble printing XML to file");
		}
	}

	public void addNewStage(Stage aStage){
		myStages.add(aStage);
	}

}
