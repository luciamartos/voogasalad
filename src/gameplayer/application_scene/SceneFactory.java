package gameplayer.application_scene;

import javafx.stage.Stage;

public class SceneFactory {

	public IDisplay create(SceneIdentifier aIdentifier){
		if(aIdentifier.equals(SceneIdentifier.LOGIN)){
			return new LoginScene();
		} else if(aIdentifier.equals(SceneIdentifier.MAINMENU)){
			return new MainMenuScene();
		} else if(aIdentifier.equals(SceneIdentifier.GAMECHOICE)){
			return new GameChoiceScene();
		} else if(aIdentifier.equals(SceneIdentifier.GAMEPLAY)){
			return new GamePlayScene();
		} else {
			return null;
		}
	}
}
