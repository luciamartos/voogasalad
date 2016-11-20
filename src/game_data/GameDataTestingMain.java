package game_data;

import game_data.sprites.Player;

public class GameDataTestingMain {

	public static void main(String[] args){
		Sprite aSprite = new Player(new Location(0,0,0), "path/spriteImage.jpg", 10, 100, 100);
		Level aLevel = new Level(500, 8000, "path/backgroundImage.jpg");
		aLevel.addNewSprite(aSprite);
		Game aGame = new Game();
		aGame.addNewLevel(aLevel);
		aGame.saveGameAs("XMLGameFiles/","TestXMLFile");
	}
}
