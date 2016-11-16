package gameplayer.application_controller;

import gameplayer.application_scene.GameChoiceScene;
import gameplayer.application_scene.LoginScene;
import gameplayer.application_scene.MainMenuScene;
import javafx.stage.Stage;

/**
 * Where the player part can interact with the game engine and get the appropriate data to be displayed
 * 
 * @author tedmarchildon, hannah
 *
 */

public class ApplicationController {

	private Stage myStage;

	public ApplicationController(Stage astage){
		myStage = astage;
	}

	public void displayLogin(){
		LoginScene login = new LoginScene();
		myStage.close();
		myStage.setScene(login.init());
		login.setOnEnter(e -> {
			displayMainMenu();
		});
		myStage.show();
	}
	
	public void displayMainMenu(){
		MainMenuScene mainMenu = new MainMenuScene();
		myStage.close();
		myStage.setScene(mainMenu.init());
		mainMenu.setOnPlay(e -> {
			displayGameChoice();
		});
		mainMenu.setOnAuthor(e -> {
			//TODO: implement authoring environment
		});
		mainMenu.setOnSignOut(e -> {
			displayLogin();
		});
		myStage.show();
	}
	
	private void displayGameChoice(){
		GameChoiceScene gameChoice = new GameChoiceScene();
		myStage.close();
		myStage.setScene(gameChoice.init());
		gameChoice.setOnChoose(e -> {
			GamePlayController gamePlay = new GamePlayController(myStage);
			gamePlay.displayGame();
		});
		gameChoice.setOnLoad(e -> {
			// TODO: Implement file chooser
		});
		myStage.show();
	}
}
