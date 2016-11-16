package gameplayer.application_scene;

public class SceneFactory {

	public IDisplay create(String aIdentifier){
		if(aIdentifier.equals(SceneIdentifier.LOGIN.toString())){
			return new LoginScene();
		} else if(aIdentifier.equals(SceneIdentifier.MAINMENU.toString())){
			return new MainMenuScene();
		} else if(aIdentifier.equals(SceneIdentifier.GAMECHOICE.toString())){
			return new GameChoiceScene();
		} else if(aIdentifier.equals(SceneIdentifier.GAMEPLAY.toString())){
			return new GamePlayScene();
		} else {
			return null;
		}
	}
}
