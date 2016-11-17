package gameplayer.application_controller;

import gameplayer.application_scene.ApplicationScene;
import gameplayer.application_scene.SceneIdentifier;
import javafx.stage.Stage;

/**
 * Where the player part can interact with the game engine and get the appropriate data to be displayed
 * 
 * @author tedmarchildon, hannah
 *
 */
public class ApplicationController {
	
	private ApplicationScene mySceneBuilder;
	
	public ApplicationController(Stage aStage) {
		mySceneBuilder = new ApplicationScene(aStage); 
	}

	public void loginScene() {
		mySceneBuilder.createScene(SceneIdentifier.LOGIN);
	}
	
	public void gameChoiceScene() {
		mySceneBuilder.createScene(SceneIdentifier.GAMECHOICE);
	}
	
	public void gamePlayScene() {
		mySceneBuilder.createScene(SceneIdentifier.GAMEPLAY);
	}
	
	public void mainMen() {
		mySceneBuilder.createScene(SceneIdentifier.MAINMENU);
	}
	
}
