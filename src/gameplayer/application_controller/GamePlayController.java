package gameplayer.application_controller;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import game_data.Game;
import game_data.Sprite;
import game_engine.EnginePlayerController;
import game_engine.GameEngine;
import game_engine.UpdateGame;
import gameplayer.animation_loop.AnimationLoop;
import gameplayer.back_end.keycode_handler.KeyCodeHandler;
import gameplayer.front_end.application_scene.GamePlayScene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import util.XMLTranslator;

public class GamePlayController extends AbstractController {
	
	private EnginePlayerController myGameController;
	private UpdateGame myGameUpdater;
	private GameEngine myGameEngine;
	private File myGameFile;
	private AnimationLoop myAnimationLoop;
	private KeyCodeHandler myKeyHandler;
	private GamePlayScene myGamePlayScene;
	private Set<KeyCode> myKeySet;
	private Set<KeyCode> myKeysPressed;
	private Set<KeyCode> myKeysReleased;
	private Map<Sprite, ImageView> mySpriteMap;
	
	public GamePlayController(Stage aStage, File aFile) {
		myStage = aStage;
		myGameFile = aFile;
		mySpriteMap = new HashMap<Sprite, ImageView>();
		initializeKeySets(); 
		initializeEngineComponents(aFile);
		myGamePlayScene = new GamePlayScene(myKeyHandler, myGameController.getMyBackgroundImageFilePath(), aStage.getWidth(), aStage.getHeight());
	}

	private void initializeEngineComponents(File aFile) {
		myGameEngine = new GameEngine(aFile, 0);
		myGameController = myGameEngine.getMyEnginePlayerController();
		myGameUpdater = new UpdateGame();
	}

	private void initializeKeySets() {
		myKeySet = new HashSet<KeyCode>();
		myKeysPressed= new HashSet<KeyCode>();
		myKeysReleased = new HashSet<KeyCode>();
		myKeyHandler = new KeyCodeHandler();
	}
	
	public void displayGame() {
		initializeScene();
		updateSprites();
		initializeAnimation();
		setMenu();
		resetStage(myGamePlayScene);
	}

	private void initializeScene() {
		myGamePlayScene = new GamePlayScene(myKeyHandler, myGameController.getMyBackgroundImageFilePath(), myStage.getWidth(), myStage.getHeight());
		myGamePlayScene.setKeyHandlers(e -> handleKeyPress(e), e -> handleKeyRelease(e));
	}

	private void initializeAnimation() {
		myAnimationLoop = new AnimationLoop();
		myAnimationLoop.init( elapsedTime -> {
			resetSprites(elapsedTime);
			updateScene();
		});
	}

	private void resetSprites(double elapsedTime) {
		myGamePlayScene.clearSprites();
		myGameUpdater.update(myGameController.getMyGame(), elapsedTime, myKeysPressed, myKeysReleased, mySpriteMap);
		updateSprites();
	}

	private void updateScene() {
		//the below line makes sure the keys released aren't stored in the set after they're released
		clearKeys();
		myKeyHandler.setMovement(myGameController.getMyLevel().getMainPlayer().getMyXVelocity());
		myGamePlayScene.moveScreen();
	}
	
	private void updateSprites() {
		for (Sprite sprite : myGameController.getMySpriteList()) {
			getUpdatedSpriteMap(sprite);
		}
	}
	
	private void getUpdatedSpriteMap(Sprite aSprite) {
		ImageView image;
		if (mySpriteMap.containsKey(aSprite)) {
			image = mySpriteMap.get(aSprite);
		} else {
			image = new ImageView(aSprite.getMyImagePath());
			mySpriteMap.put(aSprite, image);
		}
		setImageProperties(aSprite, image);
		myGamePlayScene.addImageToView(mySpriteMap.get(aSprite));
	}

	private void setImageProperties(Sprite aSprite, ImageView image) {
		image.setFitWidth(aSprite.getMyWidth());
		image.setFitHeight(aSprite.getMyHeight());
		image.setX(aSprite.getMyLocation().getXLocation());
		image.setY(aSprite.getMyLocation().getYLocation());
	}

	private void clearKeys() {
		myKeysReleased.clear();
		myKeysPressed.clear();
	}
	
	@SuppressWarnings("unchecked")
	private void setMenu() {
		String[] names = {"Main Menu"};
		ImageView image = myGUIGenerator.createImage("data/gui/clip_art_hawaiian_flower.png",30);
		myGamePlayScene.addMenu(image, names, e -> {
			myAnimationLoop.stop();
			ApplicationController appControl = new ApplicationController(myStage);
			appControl.displayMainMenu();
		});
		String[] namesForGamePlay = {"Restart", "Change to Red", "Save"};
		myGamePlayScene.addMenu("GAME PLAY", namesForGamePlay, e -> {
			myAnimationLoop.stop();
			GamePlayController gameControl = new GamePlayController(myStage, myGameFile);
			gameControl.displayGame();
		}, e -> {
			myGamePlayScene.changeBackground(Color.RED);
		}, e -> {
			save();
		});
	}
	
	private void save() {
		Game currentGame = myGameController.getMyGame();
		XMLTranslator mySaver = new XMLTranslator();
		mySaver.saveToFile(currentGame, "XMLGameFiles/", "MarioOnScreenSaved");
	}
	
	private void handleKeyPress(KeyCode aKey) {
		myKeysPressed.add(aKey);
        myKeySet.add(aKey);
	}
	
	private void handleKeyRelease(KeyCode key) {
		myKeysReleased.add(key);
		myKeySet.remove(key);
	}
}