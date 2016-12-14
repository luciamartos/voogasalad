package game_data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game_data.characteristics.Characteristic;
import game_data.characteristics.ScoreBasedOnPosition;
import util.XMLTranslator;

/**
 * A Game has a List of Levels. Each Level may contain Sprites and other
 * elements. A Game can be saved to a serialized XML file to be loaded
 * elsewhere.
 * 
 * @author Addison, Cleveland Thompson
 *
 */
public class Game extends GameObject {

	/*
	 * description
	 * icon
	 */

	List<Level> myLevels;
	Set<Sprite> mySpritePresets = new HashSet<>();
	Level myCurrentLevel;
	String myDescription;
	String myIconPath;
	ScrollType myScrollType;
	String myAudioFilePath;
	boolean hasWon;
	boolean hasLost;

	public Game(String aName) {
		setName(aName);
		myLevels = new ArrayList<Level>();
		myDescription = "New VOOGASalad Game";
		myIconPath = "data/images/game_icons/flower-icon.jpg";
		myScrollType = ScrollType.CENTER;
		myAudioFilePath = "data/audio/Super-Mario-Song.mp3";
		hasWon=false;
		hasLost=false;
	}

	public boolean hasWon() {
		return hasWon;
	}

	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}

	public boolean hasLost() {
		return hasLost;
	}

	public void setHasLost(boolean hasLost) {
		this.hasLost = hasLost;
	}

	/**
	 * Saves Game, Levels, and all states to a serialized XML File
	 * 
	 * @param filePath
	 * @param fileName
	 * @author Addison
	 * @throws IOException 
	 */
	public void saveGameAs(String filePath, String fileName) throws IOException {
		java.io.FileWriter fw;
		try {
			fw = new java.io.FileWriter(filePath + fileName + ".xml");
			fw.write(((new XMLTranslator()).serialize(this)));
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new IOException();
//			System.out.println("Trouble printing XML to file");
		}
	}
	public int getLevelNumber(){
		return myLevels.indexOf(myCurrentLevel);
	}
	public void addNewLevel(Level aLevel) {
		this.myCurrentLevel = aLevel;
		myLevels.add(aLevel);
		this.notifyListeners();
	}

	public List<Level> getLevels() {
		return myLevels;
	}

	public void setCurrentLevel(Level aLevel) {
		this.myCurrentLevel = aLevel;
		if (this.myCurrentLevel.getMainPlayer()!=null)
			for(Characteristic c: myCurrentLevel.getMainPlayer().getCharacteristics()){
				if(c instanceof ScoreBasedOnPosition){
					((ScoreBasedOnPosition) c).setScrollDirection(myScrollType);
				}
			}
		
		this.notifyListeners();
	}

	public void addPreset(Sprite aPresetSprite) {
		this.mySpritePresets.add(aPresetSprite);
		this.notifyListeners();
	}

	public Set<Sprite> getPresets() {
		return Collections.unmodifiableSet(this.mySpritePresets);
	}

	public void removePreset(Sprite aSprite) {
		if (this.mySpritePresets.contains(aSprite))
			this.mySpritePresets.remove(aSprite);
		this.notifyListeners();
	}

	public void setCurrentLevel(int levelNumber) {
		myCurrentLevel = myLevels.get(levelNumber);
		if(myCurrentLevel.getMainPlayer() != null){
			for(Characteristic c: myCurrentLevel.getMainPlayer().getCharacteristics()){
				if(c instanceof ScoreBasedOnPosition){
					((ScoreBasedOnPosition) c).setScrollDirection(myScrollType);
				}
			}
		}
		this.notifyListeners();
	}

	public Level getCurrentLevel() {
		return myCurrentLevel;
	}

	public void removeLevel(Level aLevel){
		if(myLevels.contains(aLevel))
			myLevels.remove(aLevel);
		this.notifyListeners();
	}

	public void removeLevel(int levelNumber){
		if(myLevels.size() > levelNumber)
			myLevels.remove(levelNumber);
		this.notifyListeners();
	}

	public String getDescription() {
		return myDescription;
	}

	public void setDescription(String aDescription) {
		this.myDescription = aDescription;
	}

	public String getIconPath() {
		return myIconPath;
	}

	public void setIconPath(String aIconPath) {
		this.myIconPath = aIconPath;
	}

	public ScrollType getScrollType() {
		return myScrollType;
	}

	public void setScrollType(ScrollType aScrollType) {
		this.myScrollType = aScrollType;
	}

	public String getAudioFilePath() {
		return this.myAudioFilePath;
	}

	public void setAudioFilePath(String aAudioFilePath) {
		this.myAudioFilePath = aAudioFilePath;
	}

}
