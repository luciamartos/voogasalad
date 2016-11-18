package game_data;

import author.model.game_observables.observable_level.ObservableLevel;
import author.model.game_observables.observable_level.ObservableLevelFactory;

public class GameDataTestingMain {

	public static void main(String[] args){
		Sprite aSprite = new Player(new Location(0,0,0), "path/spriteImage.jpg");
		ObservableLevel aLevel = new ObservableLevelFactory().create(500, 500, "Image");
		aLevel.addNewSprite(aSprite);
		Game aGame = new Game();
		aGame.addNewLevel(aLevel);
		aGame.saveGameAs("XMLGameFiles/","TestXMLFile");
	}
}
