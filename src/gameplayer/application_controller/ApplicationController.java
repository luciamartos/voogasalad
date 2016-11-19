package gameplayer.application_controller;

import java.io.File;
import java.io.FileNotFoundException;

import gameplayer.application_scene.AbstractNavigationPlayerScene;
import gameplayer.application_scene.FileManager;
import gameplayer.application_scene.IDisplay;
import gameplayer.application_scene.LoginScene;
import gameplayer.application_scene.MainMenuScene;
import gameplayer.application_scene.PlayerOptions;
import gameplayer.application_scene.PopUpManager;
import javafx.scene.layout.HBox;
import gameplayer.application_scene.SceneFactory;
import gameplayer.application_scene.SceneIdentifier;
import gameplayer.gui_generator.IGUIGenerator.ButtonDisplay;
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
	private PlayerInformationController myInformationController;

	public ApplicationController(Stage aStage){
		myStage = aStage;
		mySceneBuilder = new SceneFactory();
		myInformationController = new PlayerInformationController();
	}

	public void displayLogin() {
		LoginScene login = (LoginScene) mySceneBuilder.create(SceneIdentifier.LOGIN, myStage.getWidth(), myStage.getHeight());
		resetStage(login);
		setLoginButtonHandlers((LoginScene) login);
	}

	public void displayMainMenu() {
		MainMenuScene mainMenu = (MainMenuScene) mySceneBuilder.create(SceneIdentifier.MAINMENU, myStage.getWidth(), myStage.getHeight());
		resetStage(mainMenu);
		setMainMenuButtonHandlers(mainMenu);
	}
	
	private void setLoginButtonHandlers(LoginScene login){
		login.addButton("Enter", e -> {
			displayMainMenu();
			myInformationController.userSignIn(login.getUserName(), login.getPassword());
		}, ButtonDisplay.TEXT);
		login.addButton("Sign Up", e -> {
			//TODO: 
			displayMainMenu();
			myInformationController.userSignUp(login.getUserName(), login.getPassword());
		}, ButtonDisplay.TEXT);
	}

	private void setMainMenuButtonHandlers(IDisplay mainMenu) {
		mainMenu.addButton("Click To Play", e -> {
			displayGameChoice();
		}, ButtonDisplay.TEXT);
		mainMenu.addButton("Click To Author", e -> {
			//TODO: implement authoring environment
		}, ButtonDisplay.TEXT);
		mainMenu.addButton("Sign Out", e -> {
			displayLogin();
		}, ButtonDisplay.TEXT);
	}
	
	private void createNavigationButtons(IDisplay aMenu) {
		aMenu.addNavigationButton("Main Menu", e -> {
			displayMainMenu();
		}, ButtonDisplay.TEXT);
		aMenu.addNavigationButton("Sign Out", e -> {
			displayLogin();
		}, ButtonDisplay.TEXT);
		aMenu.addNavigationButton("user-profile-button", e -> {
			//TODO
		}, ButtonDisplay.CSS);
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
		}, ButtonDisplay.TEXT);
		gameChoice.addButton("Load New Game", e -> {
			File chosenGame = new FileManager().show(myStage);
			if (chosenGame != null){
				//TODO: Send selected file to backend
			}
		}, ButtonDisplay.TEXT);
		gameChoice.addButton("Options", a -> {
			PopUpManager popup = new PopUpManager();
			PlayerOptions options = new PlayerOptions();
			for(HBox box : options.addOptions()){
				popup.addOption(box);
			}
			
			popup.show();
		}, ButtonDisplay.TEXT);
	}
	
	private void resetStage(IDisplay aScene){
		myStage.close();
		myStage.setScene(aScene.init());
		myStage.show();
		createNavigationButtons(aScene);
	}

	public void startScene() throws FileNotFoundException {
		IDisplay login = mySceneBuilder.create(SceneIdentifier.LOGIN, SCENE_WIDTH, SCENE_HEIGHT);
		resetStage(login);
		setLoginButtonHandlers((LoginScene) login);
	}
}
