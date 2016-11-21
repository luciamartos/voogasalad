package game_data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Game has a List of Levels. Each Level may contain Sprites
 * and other elements. A Game can be saved to a serialized XML
 * file to be loaded elsewhere.
 * 
 * @author Addison, Cleveland Thompson
 *
 */
public class Game extends GameObject{
	
	List<Level> myLevels;
	Set<Sprite> spritePresets = new HashSet<>();
	
	public Game(String aName){
		setName(aName);
		myLevels = new ArrayList<Level>();
	}

	/**
	 * Saves Game, Levels, and all states to a serialized XML File
	 * 
	 * @param filePath
	 * @param fileName
	 * @author Addison
	 */
	public void saveGameAs(String filePath, String fileName){
	    java.io.FileWriter fw;
		try {
			fw = new java.io.FileWriter(filePath + fileName + ".xml");
		    fw.write(((new XMLSaver()).serialize(this)));
		    fw.close();
		} catch (IOException e) {
			System.out.println("Trouble printing XML to file");
		}
	}

	public void addNewLevel(Level aLevel){
		myLevels.add(aLevel);
		this.notifyListeners();
	}
	
	public List<Level> getLevels(){
		return myLevels;
	}
	
	public void addPreset(Sprite aPresetSprite){
		this.spritePresets.add(aPresetSprite);
		this.notifyListeners();
	}
	
	public Set<Sprite> getPresets(){
		return Collections.unmodifiableSet(this.spritePresets);
	}

}
