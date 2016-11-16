package gameplayer.application_controller;

import gameplayer.application_scene.GamePlayScene;
import javafx.stage.Stage;

public class GamePlayController {
	
	private Stage myStage;
	private GamePlayScene myGamePlay;
	
	public GamePlayController(Stage astage){
		myStage = astage;
	}
	
	public void displayGame(){
		myGamePlay = new GamePlayScene();
		resetStage();
		setButtonHandlers();
	}

	private void setButtonHandlers() {
		myGamePlay.setOnMain(e -> {
			ApplicationController appControl = new ApplicationController(myStage);
			appControl.displayMainMenu();
		});
		myGamePlay.setOnRestart(e -> {
			displayGame();
		});
	}
	
	private void resetStage(){
		myStage.close();
		myStage.setScene(myGamePlay.init());
		myStage.show();
	}
}
