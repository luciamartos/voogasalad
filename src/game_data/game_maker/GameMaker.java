package game_data.game_maker;

import java.util.Collections;
import java.util.List;


import game_data.Game;
import game_data.Level;
import game_data.Location;
import game_data.Sprite;
import game_data.characteristics.Characteristic;

/**
 * 
 * @author Addison, Cleveland Thompson
 *
 */
class GameMaker implements IGameMaker{

	private Game myActiveGame;
	private Level myActiveLevel;
	private Sprite myActiveSprite;
	private String myGameFilePath = null;
	private String myGameFileName = null;
	
	/**
	 * 
	 */
	public GameMaker() {
	}
	
	public void makeNewGame(){
		myActiveGame = new Game();
		myGameFilePath = null;
		myGameFileName = null;
	}

	public void saveGame(){
		if (myGameFilePath == null && myGameFileName == null)
			saveGameAs();
		else
			myActiveGame.saveGameAs(myGameFilePath, myGameFileName);
	}

	public void saveGameAs(){
		// prompt user somehow to get filepath
		String myGameFilePath = ""; // prompt here
		String myGameFileName = ""; // prompt here
		myActiveGame.saveGameAs(myGameFilePath, myGameFileName);
	}

	public Level makeNewLevel(int aWidth, int aHeight, String aBackgroundImageFilePath){
		myActiveLevel = new Level(aWidth, aHeight, aBackgroundImageFilePath);
		myActiveGame.addNewLevel(myActiveLevel);
		return myActiveLevel;
	}
	
	public List<Level> getLevels(){
		// unmodifiable so that they have to manually add level
		return Collections.unmodifiableList(this.myActiveGame.getLevels());
	}

	public Sprite makeNewSprite(String SpriteType, Location aLocation, String aImagePath){
		try {
			Class<?> c = Class.forName("game_data.sprites" + SpriteType);
			myActiveSprite = (Sprite) c.newInstance();
			myActiveLevel.addNewSprite(myActiveSprite);
			return myActiveSprite;
		} catch (ClassNotFoundException e) {
			// TODO
		} catch (InstantiationException e) {
			// TODO
		} catch (IllegalAccessException e) {
			// TODO
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see game_data.game_maker.IGameMaker#cloneSprite(game_data.Sprite)
	 */
	@Override
	public void cloneSprite(Sprite aSprite) {
		myActiveSprite = aSprite.clone();
		myActiveLevel.addNewSprite(myActiveSprite);
	}

	/* (non-Javadoc)
	 * @see game_data.game_maker.IGameMaker#getActiveLevel()
	 */
	@Override
	public Level getActiveLevel() {
		return this.myActiveLevel;
	}

	/* (non-Javadoc)
	 * @see game_data.game_maker.IGameMaker#setActiveLevel(game_data.Level)
	 */
	@Override
	public void setActiveLevel(Level aLevel) {
		this.myActiveLevel = aLevel;
	}
	


}
