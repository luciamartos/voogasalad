package gameplayer.application_scene;

import javafx.stage.Stage;

public class SceneFactory {

	public IDisplay create(Stage aStage, String aIdentifier){
		if(aIdentifier.equals("Login")){
			return new LoginScene(aStage);
		} else if(aIdentifier.equals("MainMenu")){
			return new MainMenuScene(aStage);
		} else if(aIdentifier.equals("GameChoice")){
			return new GameChoiceScene(aStage);
		} else if(aIdentifier.equals("GamePlay")){
			return new GamePlayScene(aStage);
		} else {
			return null;
		}
	}
}
