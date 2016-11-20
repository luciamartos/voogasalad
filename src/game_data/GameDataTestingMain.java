package game_data;

import java.io.File;

import util.XMLTranslator;
import game_data.sprites.Player;

public class GameDataTestingMain {

	public static void main(String[] args){
		Sprite aSprite = new Player(new Location(0,0,0), 100, 100, "Addison", "path/spriteImage.jpg");
		Level aLevel = new Level(500, 8000, "path/backgroundImage.jpg");
		aLevel.addNewSprite(aSprite);
		Game aGame = new Game();
		aGame.addNewLevel(aLevel);
		File aFile = new File("XMLGameFiles/TestXMLFile.xml");
		XMLTranslator myXMLSaver = new XMLTranslator();
		aGame.saveGameAs("XMLGameFiles/","TestXMLFilea");
		Game bGame = (Game) myXMLSaver.deserialize(aFile);
		Sprite bSprite = aSprite.clone();
		bSprite.setMyLocation(new Location(100,100,90));
		bGame.myLevels.get(0).addNewSprite(bSprite);
		System.out.println(myXMLSaver.serialize(bGame));
		myXMLSaver.saveToFile(bGame, "XMLGameFiles/", "TestXMLFileb");
	}
}
