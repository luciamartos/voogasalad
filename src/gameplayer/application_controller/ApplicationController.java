package gameplayer.application_controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import gameplayer.application_scene.IDisplay;
import gameplayer.application_scene.LoginScene;
import gameplayer.application_scene.MainMenuScene;
import gameplayer.application_scene.PlayerOptions;
import gameplayer.application_scene.PopUpController;
import gameplayer.application_scene.FileController;
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
	
	private static final String FILE = "gameplayerlabels.";
	private static final String BUTTONLABEL = "ButtonLabels"; 
	
	public static final int SCENE_WIDTH = 1000;
	public static final int SCENE_HEIGHT = 1000;

	private Stage myStage;
	private SceneFactory mySceneBuilder;
	private PlayerInformationController myInformationController;
	private ResourceBundle myButtonLabels; 

	public ApplicationController(Stage aStage) {
		myStage = aStage;
		mySceneBuilder = new SceneFactory();
		myInformationController = new PlayerInformationController();
		myButtonLabels = PropertyResourceBundle.getBundle(FILE + BUTTONLABEL);
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
		login.addButton(myButtonLabels.getString("Enter"), e -> {
			displayMainMenu();
			myInformationController.userSignIn(login.getUserName(), login.getPassword());
		}, ButtonDisplay.TEXT);
		login.addButton(myButtonLabels.getString("SignUp"), e -> {
			//TODO: 
			displayMainMenu();
			myInformationController.userSignUp(login.getUserName(), login.getPassword());
		}, ButtonDisplay.TEXT);
	}

	private void setMainMenuButtonHandlers(IDisplay mainMenu) {
		mainMenu.addButton(myButtonLabels.getString("Play"), e -> {
			displayGameChoice();
		}, ButtonDisplay.TEXT);
		mainMenu.addButton(myButtonLabels.getString("Author"), e -> {
			//TODO: implement authoring environment
		}, ButtonDisplay.TEXT);
	}
	
	private void createNavigationButtons(IDisplay aMenu) {
		aMenu.addNavigationButton(myButtonLabels.getString("Profile"), e -> {
			displayUserProfile();
		}, ButtonDisplay.CSS);
		aMenu.addNavigationButton(myButtonLabels.getString("MainMenu"), e -> {
			displayMainMenu();
		}, ButtonDisplay.TEXT);
		aMenu.addNavigationButton(myButtonLabels.getString("SignOut"), e -> {
			displayLogin();
		}, ButtonDisplay.TEXT);
	}
	
	private void displayUserProfile() {
		IDisplay userProfile = mySceneBuilder.create(SceneIdentifier.USERPROFILE, myStage.getWidth(), myStage.getHeight());
		resetStage(userProfile);
		setUserProfileButtonHandlers(userProfile);
	}
	
	private void setUserProfileButtonHandlers(IDisplay userProfile) {
		userProfile.addButton("HI!", e -> {
			//do nothing
		}, ButtonDisplay.TEXT);
	}
	
	private void displayGameChoice(){
		IDisplay gameChoice = mySceneBuilder.create(SceneIdentifier.GAMECHOICE, myStage.getWidth(), myStage.getHeight());
		resetStage(gameChoice);
		setGameChoiceButtonHandlers(gameChoice);
	}

	private void setGameChoiceButtonHandlers(IDisplay gameChoice) {
		gameChoice.addButton(myButtonLabels.getString("ChooseGame"), e -> {
			GamePlayController gamePlay = new GamePlayController(myStage);
			gamePlay.displayGame();
		}, ButtonDisplay.TEXT);
		gameChoice.addButton(myButtonLabels.getString("Load"), e -> {
			File chosenGame = new FileController().show(myStage);
			if(chosenGame != null){
				//TODO: Send selected file to backend
			}
		}, ButtonDisplay.TEXT);
		gameChoice.addButton(myButtonLabels.getString("Options"), a -> {
			PopUpController popup = new PopUpController();
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
