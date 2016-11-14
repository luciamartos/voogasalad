package game_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.input.KeyCode;

/**
 * Represents a level of a Game. Has a List of Sprites
 * active on that Stage as well as a background image and
 * Stage specific KeyCommands
 * 
 * @author Addison
 */
public class Stage {
	
	private int width, height;
	private String backgroundImageFilePath;
	Stage nextStage;
	List<Sprite> mySprites;
	Map<KeyCode, KeyCommand> myKeyCommands;
	
	public Stage(int width, int height, String backgroundImageFilePath){
		this.width = width;
		this.height = height;
		this.backgroundImageFilePath = backgroundImageFilePath;
		nextStage = null;
		mySprites = new ArrayList<Sprite>();
		myKeyCommands = new HashMap<KeyCode, KeyCommand>();
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setBackgroundImageFilePath(String backgroundImageFilePath){
		this.backgroundImageFilePath = backgroundImageFilePath;
	}
	
	public String getBackgroundImageFilePath(){
		return backgroundImageFilePath;
	}
	
	public void addNewSprite(Sprite  aSprite){
		mySprites.add(aSprite);
	}
	
	public void addNewKeyCommand(KeyCode aKeyCode, KeyCommand aKeyCommand){
		myKeyCommands.put(aKeyCode, aKeyCommand);
	}

}
