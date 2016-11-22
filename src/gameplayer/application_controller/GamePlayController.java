package gameplayer.application_controller;

import java.util.HashSet;
import java.util.Set;
import gameplayer.front_end.application_scene.AnimationScene;
import gameplayer.front_end.gui_generator.IGUIGenerator.ButtonDisplay;
import gameplayer.front_end.heads_up_display.HeadsUpDisplay;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GamePlayController {
	
	private Stage myStage;
	private AnimationScene myGamePlay;
	private HeadsUpDisplay myHeadsUpDisplay;
	private StackPane myStack;
	private Scene myScene;
	private Set<KeyCode> myKeySet;
	
	public GamePlayController(Stage astage) {
		myStage = astage;
		myKeySet = new HashSet<KeyCode>();
		myStack = new StackPane();
		myScene = new Scene(myStack, myStage.getWidth(), myStage.getHeight());
		myScene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));
		myScene.setOnKeyReleased(e -> handleKeyRelease(e.getCode()));
	}
	
	public void displayGame() {
		initializeGameScene();
		resetStage();
		setButtonHandlers();
	}

	private void initializeGameScene() {
		myGamePlay = new AnimationScene(myScene, myStage.getWidth(), myStage.getHeight());
		myStack.getChildren().add(myGamePlay.init());
		myHeadsUpDisplay = new HeadsUpDisplay(myScene, myStage.getWidth(), myStage.getHeight());
		myStack.getChildren().add(myHeadsUpDisplay.init());
	}
	
//austin is great
	private void setButtonHandlers() {
		myHeadsUpDisplay.addButton("Main Menu", e -> {
			ApplicationController appControl = new ApplicationController(myStage);
			appControl.displayMainMenu();
		}, ButtonDisplay.TEXT);
		myHeadsUpDisplay.addButton("Restart", e -> {
			displayGame();
		}, ButtonDisplay.TEXT);
		myHeadsUpDisplay.addButton("Change to Red", e -> {
			myGamePlay.makeRed();
		}, ButtonDisplay.TEXT);
	}
	
	private void resetStage() {
		myStage.close();
		myStage.setScene(myScene);
		myStage.show();
	}
	
	private void handleKeyPress(KeyCode aKey) {
        myKeySet.add(aKey);
        System.out.println("new");
        for (KeyCode key : myKeySet) {
        	System.out.println(key);
        }
	}
	
	private void handleKeyRelease(KeyCode key) {
		//System.out.println(myKeySet);
		myKeySet.remove(key);
	}
}
