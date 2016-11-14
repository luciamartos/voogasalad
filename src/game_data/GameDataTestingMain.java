package game_data;

public class GameDataTestingMain {

	public static void main(String[] args){
		Sprite aSprite = new Player(new Location(0,0), "path/spriteImage.jpg");
		Stage aStage = new Stage(500, 8000, "path/backgroundImage.jpg");
		aStage.addNewSprite(aSprite);
		Game aGame = new Game();
		aGame.addNewStage(aStage);
		aGame.saveGameAs("XMLGameFiles/","TestXMLFile");
	}
}
