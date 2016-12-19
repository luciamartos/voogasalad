package gameplayer.application_controller;

import java.io.File;
import author.view.pages.level_editor.windows.splash_screen.AuthoringSplashScreenFactory;
import author.view.pages.level_editor.windows.splash_screen.IAuthoringSplashScreen;
import gameplayer.back_end.exceptions.GameNotFunctionalException;
import gameplayer.back_end.exceptions.VoogaFacebookException;
import gameplayer.back_end.resources.FrontEndResources;
import gameplayer.back_end.stored_games.StoredGames;
import gameplayer.back_end.user_information.LevelManager;
import gameplayer.front_end.application_scene.IDisplay;
import gameplayer.front_end.application_scene.INavigationDisplay;
import gameplayer.front_end.application_scene.MainMenuScene;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import gameplayer.front_end.application_scene.SceneIdentifier;
import gameplayer.front_end.gui_generator.IGUIGenerator.ButtonDisplay;
import gameplayer.front_end.popup.PopUpFactory;
import gameplayer.front_end.popup.UserOptions;
import gameplayer.front_end.popup.LevelSelectionPopUp;
import gameplayer.front_end.popup.PlayerOptionsPopUp;
import javafx.stage.Stage;

//This entire file is part of my masterpiece.
//HANNAH FUCHSHUBER

/**
 * Where the player part can interact with the game engine and get the appropriate data to be displayed
 * 
 * I choose this class to be my analysis because it shows how we organized the front-end. We wanted to have a modularized 
 * front-end, so we decided to use lambdas to control the flow of execution - you can see our use of lambdas here. And we 
 * wanted for all the logic to be done in the controllers, so we did not actually create an JavaFX Nodes here (instead that work
 * was delegated out to other classes), but we wanted for the Controllers to handle the interaction between the front-end and the 
 * back-end and you can see that we instantiate the back-end (GamePlayController) in this class. I think that by having all of the 
 * logic for the front-end done in Controllers we mitigated the amount of things that we would have to pass around.
 * We also make use of interfaces- we have the IDisplay class and the INavgationDisplay which handles the creation of all our 
 * scenes- because as you can see from this code they are all essentially the same. 
 * 
 * @author tedmarchildon, hannah
 *
 */

public class ApplicationController extends AbstractController {

	private StoredGames myStoredGames;
	private GamePlayController myGamePlay;
	private IDisplay myCurrentDisplay;

	
	/**
	 * This calls the super constructor for our Controllers, which holds the Stage
	 * 
	 * @param aStage
	 */
	public ApplicationController (Stage aStage) {
		super(aStage);
		setPlayerInformationController(new PlayerInformationController());
		myStoredGames = new StoredGames();
	}
	
	/**
	 * This displays the MainMenu page
	 * 
	 * @param aWidth
	 * @param aHeight
	 */

	public void displayMainMenu(double aWidth, double aHeight) {
		if (getStage().getScene() != null) {
			myCurrentDisplay = getSceneFactory().create(SceneIdentifier.MAINMENU, 
					getStage().getScene().getWidth(), 
					getStage().getScene().getHeight());
		} else {
			myCurrentDisplay = getSceneFactory().create(SceneIdentifier.MAINMENU, aWidth, aHeight);
		}
		resetStage(myCurrentDisplay);
		setMainMenuButtonHandlers((MainMenuScene) myCurrentDisplay);
	}

	/**
	 * This displays the Authoring environment
	 */

	private void displayAuthoring() {
		IAuthoringSplashScreen aSplashScreen = (new AuthoringSplashScreenFactory()).create();
		aSplashScreen.initializeWindow();
	}


	/**
	 * @param aGamename is used to determine which set of highscores to get
	 */
	public void displayHighScoreScene(String aGamename) {
		myCurrentDisplay = getSceneFactory().create(SceneIdentifier.HIGHSCORE, 
				getStage().getScene().getWidth(), 
				getStage().getScene().getHeight(), aGamename);
		createNavigationButtons((INavigationDisplay) myCurrentDisplay);
		resetStage(myCurrentDisplay);
	}

	/**
	 * This displays the GameChoice 2 Scene
	 * @param aGamename
	 */
	private void displayGameChoiceRoundTwo(String aGamename) {
		myCurrentDisplay = getSceneFactory().create(SceneIdentifier.GAMECHOICE, 
				getStage().getScene().getWidth(), 
				getStage().getScene().getHeight());
		resetStage(myCurrentDisplay);
		createNavigationButtons((INavigationDisplay) myCurrentDisplay);
		setGameChoiceButtonHandlers((INavigationDisplay) myCurrentDisplay, aGamename);
		setGameChoiceSecondRoundButtonHandlers((INavigationDisplay) myCurrentDisplay);
	}

	/**
	 * This displays the User Scene
	 */
	private void displayUserScene() {
		myCurrentDisplay = getSceneFactory().create(getPlayerInformationController().getUser(), 
				getPlayerInformationController().getPictureUrl(), 
				getStage().getScene().getWidth(), 
				getStage().getScene().getHeight(), 
				loadHighscores());
		resetStage(myCurrentDisplay);
		createNavigationButtons((INavigationDisplay) myCurrentDisplay);
	}
	
	/**
	 * This displays the Game Choice scene
	 */

	private void displayGameChoice() {
		myCurrentDisplay = getSceneFactory().create(SceneIdentifier.GAMECHOICE, 
				getStage().getScene().getWidth(), 
				getStage().getScene().getHeight());
		resetStage(myCurrentDisplay);
		createNavigationButtons((INavigationDisplay) myCurrentDisplay);
		setGameChoiceButtonHandlers((INavigationDisplay) myCurrentDisplay, getButtonLabels().getString("Choose"));
	}

	/**
	 * This sets the buttons handler for Game Choice scene which sets up the logic for the game
	 * @param gameChoice
	 * @param aLabel
	 */
	private void setGameChoiceButtonHandlers(INavigationDisplay gameChoice, String aLabel) {
		gameChoice.addNode(getGUIGenerator().createComboBox(aLabel, myStoredGames.getGames(), 
				myStoredGames.getIcons(), myStoredGames.getDescriptions(), getStage().getScene().getWidth(), (chosenGame) -> {
					handleNewGameFile(myStoredGames.getGameFilePath(chosenGame));
				}));
		gameChoice.addButton(getButtonLabels().getString("Load"), e -> {
			File chosenGame = new FileChoiceController().show(getStage());
			if (chosenGame != null) {
				handleNewGameFile(chosenGame);
			}
		}, ButtonDisplay.TEXT); 
	}
	
	/**
	 * This sets up the Navigation Menu at the top of the screen
	 * @param aMenu
	 */

	@SuppressWarnings("unchecked")
	private void createNavigationButtons(INavigationDisplay aMenu) {
		String[] names = {getButtonLabels().getString("MainMenu"), getButtonLabels().getString("Profile"), 
				getButtonLabels().getString("HawaiianShirt")};
		ImageView image = getGUIGenerator().createImage("data/gui/clip_art_hawaiian_flower.png",30);
		aMenu.addNavigationMenu(image, names, e -> {
			displayMainMenu(getStage().getScene().getWidth(), getStage().getScene().getHeight());
		}, e -> {
			displayUserScene();
		}, e-> {
			myCurrentDisplay.setBackground(getButtonLabels().getString("Shirt" + (int) Math.floor(Math.random() * 6)), getStage().getScene().getWidth(), getStage().getScene().getHeight());
		});
	}
	
	/**
	 * This is a button handler for the main menu page which sets the logic of the flow of the GUI
	 * 
	 * @param mainMenu
	 */
	private void setMainMenuButtonHandlers(INavigationDisplay mainMenu) {
		mainMenu.addButton(getButtonLabels().getString("Play"), e -> {
			displayGameChoice();
		}, ButtonDisplay.TEXT);
		mainMenu.addButton(getButtonLabels().getString("Author"), e -> {
			displayAuthoring();
		}, ButtonDisplay.TEXT);
		mainMenu.addButton(getButtonLabels().getString("Login"), e -> {
			try { 
				getPlayerInformationController().facebookLogin();
			} catch (Exception x) {
				showError(x);
			}
		}, ButtonDisplay.FACEBOOK);
	}
	
	/**
	 * This handles a new Game
	 * @param chosenGame
	 */

	private void handleNewGameFile(File chosenGame) {
		startEngine(chosenGame);
		getUserPreferences();
	}

	/**
	 * This starts the game with a working file and uses exceptions!
	 * @param chosenGame
	 */
	private void startEngine(File chosenGame) {
		try {
			resetGame(chosenGame);
			displayGameChoiceRoundTwo(myGamePlay.getGame().getName());
		} catch (Exception x) {
			showError(x);
			displayGameChoice();
		}
	}
	
	/**
	 * This sets up user preferences
	 * and uses exceptions!
	 */

	private void getUserPreferences() {
		try {
			getOptions();
			getLevel();
		} catch (Exception x) {
			//do nothing, the user hasn't set preferences or chosen a level
		}
	}
	
	/**
	 * This sets up the in game user options
	 */

	private void getOptions() {
		UserOptions uo = (UserOptions) getXMLHandler().load(myGamePlay.getGame().getName() + 
				getPlayerInformationController().getUser() + "options");
		myGamePlay.setOptions(uo);
	}
	
	/**
	 * This gets the level so the user can choose their level
	 * @throws Exception
	 */

	private void getLevel() throws Exception {
		LevelManager lm = (LevelManager) getXMLHandler().load(myGamePlay.getGame().getName() + "level");
		myGamePlay.setLevel(lm.getLevel());
	}
	
	/**
	 * This sets up the game choice set round button handlers to start the game
	 * @param gameChoice
	 */

	private void setGameChoiceSecondRoundButtonHandlers(INavigationDisplay gameChoice) {
		HBox hbox = new HBox(FrontEndResources.BOX_INSETS.getDoubleResource());
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(getGUIGenerator().createButton(getButtonLabels().getString("Options"), 0, 0, e -> {
			PlayerOptionsPopUp options = (PlayerOptionsPopUp) new PopUpFactory().buildPopUpDisplay();
			options.setOnClosed(k -> {
				try {
					UserOptions ud = new UserOptions(options.getColorChoice(), options.getKeyChoice());
					myGamePlay.setOptions(ud);
					getXMLHandler().save(ud, myGamePlay.getGame().getName() + 
							getPlayerInformationController().getUser() + "options");
				} catch (Exception x) {
					showError(x);
				}
			});
			options.show();
		}, ButtonDisplay.TEXT));
		hbox.getChildren().add(getGUIGenerator().createButton(getButtonLabels().getString("Levels"), 0, 0, e -> {
			LevelSelectionPopUp levelSelection = 
					(LevelSelectionPopUp) new PopUpFactory().buildPopUpDisplay(myGamePlay.getGame().getLevels().size());
			levelSelection.setOnClosed(k -> {
				try {
					myGamePlay.setLevel(levelSelection.getSelectedLevel());
				} catch (Exception e1) {
					showError(e1);
				}
			});
			levelSelection.show();
		}, ButtonDisplay.TEXT));
		gameChoice.addNode(hbox);
		gameChoice.addButton("PLAY", e -> {
			try {
				myGamePlay.displayGame();
			} catch (Exception e1) {
				showError(e1);
			}
		}, ButtonDisplay.TEXT);
	}
	
	/**
	 * This plays the game by instantiating the game controller for the back-end
	 * @param chosenGame
	 * @throws GameNotFunctionalException
	 */

	private void resetGame(File chosenGame) throws GameNotFunctionalException {
		myGamePlay = new GamePlayController(getStage(), chosenGame, this, getPlayerInformationController());
	}

	/**
	 * @param aTitle is the message title
	 * @param aMessage is the message for the post
	 */

	public void publishToFacebook(String aTitle, String aMessage) throws VoogaFacebookException {
		getPlayerInformationController().publishToFaceBook(aTitle, aMessage);
	}
}
