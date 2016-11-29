package gameplayer.application_controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import gameplayer.front_end.animated_display.AnimatedTitleDisplay;
import gameplayer.front_end.application_scene.IDisplay;
import gameplayer.front_end.application_scene.LoginScene;
import gameplayer.front_end.application_scene.MainMenuScene;
import javafx.scene.layout.HBox;
import gameplayer.front_end.application_scene.SceneFactory;
import gameplayer.front_end.application_scene.SceneIdentifier;
import gameplayer.front_end.gui_generator.GUIGenerator;
import gameplayer.front_end.gui_generator.IGUIGenerator.ButtonDisplay;
import gameplayer.front_end.popup.ErrorAlert;
import gameplayer.front_end.popup.PlayerOptionsPopUp;
import gameplayer.front_end.popup.PopUpController;
import javafx.stage.Stage;

/**
 * Where the player part can interact with the game engine and get the appropriate data to be displayed
 * 
 * @author tedmarchildon, hannah
 *
 */

public class ApplicationController {
	
	public static final int SCENE_SIZE = 1000;
	private static final String FILE = "gameplayerlabels.";
	private static final String BUTTONLABEL = "ButtonLabels"; 
	private Stage myStage;
	private SceneFactory mySceneBuilder;
	private PlayerInformationController myInformationController;
	private ResourceBundle myButtonLabels; 
	private GUIGenerator myGUIGenerator;
	
	public ApplicationController (Stage aStage) {
		myStage = aStage;
		mySceneBuilder = new SceneFactory();
		myInformationController = new PlayerInformationController();
		myButtonLabels = PropertyResourceBundle.getBundle(FILE + BUTTONLABEL);
		myGUIGenerator = new GUIGenerator();
	}
	
	public void startScene() throws FileNotFoundException {
		IDisplay mainMenu = mySceneBuilder.create(SceneIdentifier.MAINMENU, SCENE_SIZE, SCENE_SIZE);
		resetStage(mainMenu);
		setMainMenuButtonHandlers((MainMenuScene) mainMenu);
	}

	//public void displayLogin() {
		//LoginScene login = (LoginScene) mySceneBuilder.create(SceneIdentifier.LOGIN, myStage.getWidth(), myStage.getHeight());
		//resetStage(login);
		//setLoginButtonHandlers((LoginScene) login);
	//}

	public void displayMainMenu() {
		MainMenuScene mainMenu = (MainMenuScene) mySceneBuilder.create(SceneIdentifier.MAINMENU, myStage.getWidth(), myStage.getHeight());
		resetStage(mainMenu);
		setMainMenuButtonHandlers(mainMenu);
	}
	
	private void setLoginButtonHandlers(LoginScene login) {
		login.addButton(myButtonLabels.getString("Enter"), e -> {
			try {
				myInformationController.userSignIn(login.getUserName(), login.getPassword());
				displayMainMenu();
			} catch (Exception x) {
				ErrorAlert error = new ErrorAlert();
				error.show(x);
			}
		}, ButtonDisplay.TEXT);
		login.addButton(myButtonLabels.getString("SignUp"), e -> {
			try {
				myInformationController.userSignUp(login.getUserName(), login.getPassword());
				displayMainMenu();
			} catch (Exception x) {
				ErrorAlert error = new ErrorAlert();
				error.show(x);
			}
		}, ButtonDisplay.TEXT);
	}

	private void setMainMenuButtonHandlers(IDisplay mainMenu) {
		AnimatedTitleDisplay title = new AnimatedTitleDisplay();
		mainMenu.addNode(title.buildAnimatedTitleDisplay());
		mainMenu.addButton(myButtonLabels.getString("Play"), e -> {
			displayGameChoice();
		}, ButtonDisplay.TEXT);
		mainMenu.addButton(myButtonLabels.getString("Author"), e -> {
			//TODO: implement authoring environment
		}, ButtonDisplay.TEXT);
	}
	
	private void createNavigationButtons(IDisplay aMenu) {
		aMenu.addNavigationButton(myButtonLabels.getString("Profile"), e -> {
			displayUserScene();
		}, ButtonDisplay.CSS);
		aMenu.addNavigationButton(myButtonLabels.getString("MainMenu"), e -> {
			displayMainMenu();
		}, ButtonDisplay.TEXT);
		//aMenu.addNavigationButton(myButtonLabels.getString("SignOut"), e -> {
			//displayLogin();
		//}, ButtonDisplay.TEXT);
	}
	
	public void displayHighScoreScene() {
		IDisplay highScore = mySceneBuilder.create(SceneIdentifier.HIGHSCORE, myStage.getWidth(), myStage.getHeight());
		resetStage(highScore);
		setHighScoreHandlers(highScore);
	}
	
	private void setHighScoreHandlers(IDisplay highScoreScene) {
		highScoreScene.addNode(myGUIGenerator.createLabel("" + myInformationController.getHighScoresForUser("hi"), 0, 0));
	}

	private void displayUserScene() {
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
			if (chosenGame != null) {
				//TODO: Send selected file to backend
			}
		}, ButtonDisplay.TEXT);
		gameChoice.addButton(myButtonLabels.getString("Options"), a -> {
			PopUpController popup = new PopUpController();
			PlayerOptionsPopUp options = new PlayerOptionsPopUp();
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
}