package game_data;

public class GameMaker {

	private Game myActiveGame;
	private Level myActiveLevel;
	private Sprite myActiveSprite;
	private String myGameFilePath = null;
	private String myGameFileName = null;

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

	public void makeNewLevel(int aWidth, int aHeight, String aBackgroundImageFilePath){
		myActiveLevel = new Level(aWidth, aHeight, aBackgroundImageFilePath);
		myActiveGame.addNewLevel(myActiveLevel);
	}

	public void makeNewSprite(String SpriteType, Location aLocation, String aImagePath){
		try {
			Class<?> c = Class.forName("game_data.sprites" + SpriteType);
			myActiveSprite = (Sprite) c.newInstance();
			myActiveLevel.addNewSprite(myActiveSprite);
		} catch (ClassNotFoundException e) {
			// TODO
		} catch (InstantiationException e) {
			// TODO
		} catch (IllegalAccessException e) {
			// TODO
		}
	}
	
	public void cloneSprite(Sprite aSprite){
		myActiveSprite = aSprite.clone();
		myActiveLevel.addNewSprite(myActiveSprite);
	}
	
	public void setActiveLevel(Level aLevel){
		myActiveLevel = aLevel;
	}
	
	public void setActiveSprite(Sprite aSprite){
		myActiveSprite = aSprite;
	}
	
	public void addSpriteCharacteristic(Characteristic aCharacteristic){
		myActiveSprite.addCharacteristic(aCharacteristic);
	}

}
