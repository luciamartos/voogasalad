package gameplayer.application_controller;

import java.util.Observer;

import gameplayer.application_scene.GamePlayScene;
import gameplayer.application_scene.SceneFactory;
import gameplayer.application_scene.SceneIdentifier;
import gameplayer.heads_up_display.HeadsUpDisplay;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GamePlayController {
	
	private Stage myStage;
	private GamePlayScene myGamePlay;
	private HeadsUpDisplay myHeadsUpDisplay;
	private StackPane myStack;
	private Scene myScene;
	
	private class GamePlayObserver implements Observer {

        @Override
        public void update(java.util.Observable o, Object arg) {
        	//TODO: Send to game engine for processing
            System.out.println(myGamePlay.getLastKeyPressed());
        } 
	}
	
	public GamePlayController(Stage astage){
		myStage = astage;
		myStack = new StackPane();
		myScene = new Scene(myStack, myStage.getWidth(), myStage.getHeight());
	}
	
	public void displayGame(){
		initializeGameScene();
		resetStage();
		setButtonHandlers();
	}

	private void initializeGameScene() {
		SceneFactory buildGamePlayScreen = new SceneFactory();
		myGamePlay = new GamePlayScene(myScene, myStage.getWidth(), myStage.getHeight());
		myGamePlay.addObserver(new GamePlayObserver());
		myStack.getChildren().add(myGamePlay.init());
		myHeadsUpDisplay = new HeadsUpDisplay(myScene, myStage.getWidth(), myStage.getHeight());
		myStack.getChildren().add(myHeadsUpDisplay.init());
	}

	private void setButtonHandlers() {
		myHeadsUpDisplay.addButton("Main Menu", e -> {
			ApplicationController appControl = new ApplicationController(myStage);
			appControl.displayMainMenu();
		});
		myHeadsUpDisplay.addButton("Restart", e -> {
			displayGame();
		});
		myHeadsUpDisplay.addButton("Change to Red", e -> {
			myGamePlay.makeRed();
		});
	}
	
	private void resetStage(){
		myStage.close();
		myStage.setScene(myScene);
		myStage.show();
	}
}
