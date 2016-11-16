package gameplayer.application_scene;

import javafx.stage.Stage;

public class SceneFactory {

	public IDisplay create(String aIdentifier){
		if(aIdentifier.equals("LOGIN")){
			return new LoginScene();
		} else if(aIdentifier.equals("MAINMENU")){
			return new MainMenuScene();
		} else if(aIdentifier.equals("GAMECHOICE")){
			return new GameChoiceScene();
		} else if(aIdentifier.equals("GAMEPLAY")){
			return new GamePlayScene();
		} else {
			return null;
		}
	}
}
