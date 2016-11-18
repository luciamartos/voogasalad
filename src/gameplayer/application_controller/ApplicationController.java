package gameplayer.application_controller;

import java.io.File;
import gameplayer.application_scene.FileManager;
import gameplayer.application_scene.GameChoiceScene;
import gameplayer.application_scene.IDisplay;
import gameplayer.application_scene.LoginScene;
import gameplayer.application_scene.MainMenuScene;
import gameplayer.application_scene.PlayerOptions;
import gameplayer.application_scene.PopUpManager;
import javafx.scene.layout.HBox;
import gameplayer.application_scene.IDisplay;
import gameplayer.application_scene.SceneFactory;
import gameplayer.application_scene.SceneIdentifier;
import javafx.stage.Stage;

/**
 * Where the player part can interact with the game engine and get the appropriate data to be displayed
 * 
 * @author tedmarchildon, hannah
 *
 */

public class ApplicationController {
	
	public static final int SCENE_WIDTH = 1000;
	public static final int SCENE_HEIGHT = 1000;

	private Stage myStage;
	private SceneFactory mySceneBuilder;

	public ApplicationController(Stage astage){
		myStage = astage;
		mySceneBuilder = new SceneFactory();
	}

	public void displayLogin(){
		IDisplay login = mySceneBuilder.create(SceneIdentifier.LOGIN, myStage.getWidth(), myStage.getHeight());
		resetStage(login);
		setLoginButtonHandlers(login);
	}

	public void displayMainMenu(){
		IDisplay mainMenu = mySceneBuilder.create(SceneIdentifier.MAINMENU, myStage.getWidth(), myStage.getHeight());
		resetStage(mainMenu);
		setMainMenuButtonHandlers(mainMenu);
	}
	
	private void setLoginButtonHandlers(IDisplay login){
		login.addButton("Enter", e -> {
			displayMainMenu();
		});
		login.addButton("Sign Up", e -> {
			//TODO: 
		});
	}

	private void setMainMenuButtonHandlers(IDisplay mainMenu) {
		mainMenu.addButton("Click To Play", e -> {
			displayGameChoice();
		});
		mainMenu.addButton("Click To Author", e -> {
			//TODO: implement authoring environment
		});
		mainMenu.addButton("Sign Out", e -> {
			displayLogin();
		});
	}
	
	private void createNavigationButtons(IDisplay aMenu) {
		aMenu.addNavigationButton("Main Menu", e -> {
			displayMainMenu();
		});
		aMenu.addNavigationButton("Sign Out", e -> {
			displayLogin();
		});
	}
	
	private void displayGameChoice(){
		IDisplay gameChoice = mySceneBuilder.create(SceneIdentifier.GAMECHOICE, myStage.getWidth(), myStage.getHeight());
		resetStage(gameChoice);
		setGameChoiceButtonHandlers(gameChoice);
	}

	private void setGameChoiceButtonHandlers(IDisplay gameChoice) {
		gameChoice.addButton("Choose Game", e -> {
			GamePlayController gamePlay = new GamePlayController(myStage);
			gamePlay.displayGame();
		});
		gameChoice.addButton("Load New Game", e -> {
			File chosenGame = new FileManager().show(myStage);
			if(chosenGame != null){
				//TODO: Send selected file to backend
			}
		});
		gameChoice.addButton("Options", a -> {
			PopUpManager popup = new PopUpManager();
			PlayerOptions options = new PlayerOptions();
			for(HBox box : options.addOptions()){
				popup.addOption(box);
			}
			popup.show();
		});
	}
	
	private void resetStage(IDisplay aScene){
		myStage.close();
		myStage.setScene(aScene.init());
		myStage.show();
		createNavigationButtons(aScene);
	}

	public void startScene() {
		IDisplay login = mySceneBuilder.create(SceneIdentifier.LOGIN, SCENE_WIDTH, SCENE_HEIGHT);
		resetStage(login);
		setLoginButtonHandlers(login);
	}
}
