package gameplayer.application_scene;

import javafx.stage.Stage;

public class SceneFactory {

	public IDisplay create(Stage aStage, String aIdentifier){
		if(aIdentifier.equals("LOGIN")){
			return new LoginScene(aStage);
		} else if(aIdentifier.equals("MAINMENU")){
			return new MainMenuScene(aStage);
		} else if(aIdentifier.equals("GAMECHOICE")){
			return new GameChoiceScene(aStage);
		} else if(aIdentifier.equals("GAMEPLAY")){
			return new GamePlayScene(aStage);
		} else {
			return null;
		}
	}
}
