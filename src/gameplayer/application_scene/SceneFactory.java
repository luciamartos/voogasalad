package gameplayer.application_scene;

import javafx.stage.Stage;

public class SceneFactory {

	public IDisplay create(Stage aStage, SceneIdentifier aIdentifier){
		if(aIdentifier.equals(SceneIdentifier.LOGIN)){
			return new LoginScene(aStage);
		} else if(aIdentifier.equals(SceneIdentifier.MAINMENU)){
			return new MainMenuScene(aStage);
		} else if(aIdentifier.equals(SceneIdentifier.GAMECHOICE)){
			return new GameChoiceScene(aStage);
		} else if(aIdentifier.equals(SceneIdentifier.GAMEPLAY)){
			return new GamePlayScene(aStage);
		} else {
			return null;
		}
	}
}
