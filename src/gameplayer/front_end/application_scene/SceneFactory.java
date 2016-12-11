package gameplayer.front_end.application_scene;

public class SceneFactory {

	public IDisplay create(SceneIdentifier aIdentifier, double aWidth, double aHeight) {
		if (aIdentifier.equals(SceneIdentifier.MAINMENU)) {
			return new MainMenuScene(aWidth, aHeight);
		} else if (aIdentifier.equals(SceneIdentifier.GAMECHOICE)) {
			return new GameChoiceScene(aWidth, aHeight);
		} else if (aIdentifier.equals(SceneIdentifier.HIGHSCORE)) {
			return new HighScoreScene(aWidth, aHeight);
		}  
		return null;
	}
	
	public IDisplay create(String aName, String aUrl, double aWidth, double aHeight) {
		return new UserProfileScene(aName, aUrl, aWidth, aHeight);
	}
	
	public IDisplay create(SceneIdentifier aIdentifier, double aWidth, double aHeight, String aGamename){
		return new HighScoreScene(aWidth, aHeight, aGamename);
	}
}
