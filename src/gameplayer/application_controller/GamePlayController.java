package gameplayer.application_controller;

import java.util.Observer;

import gameplayer.application_scene.GamePlayScene;
import gameplayer.application_scene.SceneFactory;
import gameplayer.application_scene.SceneIdentifier;
import javafx.stage.Stage;

public class GamePlayController {
	
	private Stage myStage;
	private GamePlayScene myGamePlay;
	
	private class GamePlayObserver implements Observer {

        @Override
        public void update(java.util.Observable o, Object arg) {
        	//TODO: Send to game engine for processing
            System.out.println(myGamePlay.getLastKeyPressed());
        } 
	}
	
	public GamePlayController(Stage astage){
		myStage = astage;
	}
	
	public void displayGame(){
		initializeGameScene();
		resetStage();
		setButtonHandlers();
	}

	private void initializeGameScene() {
		SceneFactory buildGamePlayScreen = new SceneFactory();
		myGamePlay = (GamePlayScene) buildGamePlayScreen.create(SceneIdentifier.GAMEPLAY, myStage.getWidth(), myStage.getHeight());
		myGamePlay.addObserver(new GamePlayObserver());
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
