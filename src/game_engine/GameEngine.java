package game_engine;

import game_data.Game;
import util.XMLTranslator;

public class GameEngine {
	private Game myGame;
	private EnginePlayerController myEnginePlayerController;
	public GameEngine(IEngineReceiverControllerInterface myInterface) {
		makeGameFromXML(myInterface);
		myEnginePlayerController = new EnginePlayerController(myGame);
	}
	
	public GameEngine(IEngineReceiverControllerInterface myInterface, int levelNumber) {
		makeGameFromXML(myInterface);
		myGame.setCurrentLevel(levelNumber);
		myEnginePlayerController = new EnginePlayerController(myGame);
	}

	private void makeGameFromXML(IEngineReceiverControllerInterface myInterface) {
		String myXML = myInterface.getXMLRoute();
		XMLTranslator myTranslator = new XMLTranslator();
		myGame = (Game) myTranslator.deserialize(myXML);
	}
	
	public EnginePlayerController getMyEnginePlayerController(){
		return myEnginePlayerController;
	}
	
	public void setEnginePlayerController(EnginePlayerController enginePlayerController ){
		myEnginePlayerController=enginePlayerController;
	}
}
