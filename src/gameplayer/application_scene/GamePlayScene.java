package gameplayer.application_scene;


import java.util.Observable;

import gameplayer.GUIGenerator.GUIGenerator;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Concrete representation of the scene where games are played
 * 
 * @author tedmarchildon, hannah
 *
 */

public class GamePlayScene extends Observable {
	
	private Pane myGamePlayCanvas;
	private KeyCode myCurrentKeyCode = null;
	private Scene myScene;
	//private Node myBackground;
	//private SpriteDisplayController mySprites;
	
	public GamePlayScene(Scene aScene, double aWidth, double aHeight) {
		myGamePlayCanvas = new Pane();
		myScene = aScene;
	}
	
	/**
	 * Add the correct nodes to the scene
	 */
	
	public Pane init() {
		//myGamePlayCanvas = new Pane();
		//myGamePlayCanvas.setCenter(myGamePlayCanvas);
		myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		//mySprites = new SpriteDisplayController();
		//TODO: get a filepath to make the background
		//myBackground = new BackgroundDisplayFactory().buildBackgroundDisplay("fileName");
		return myGamePlayCanvas;
	}
	
	public KeyCode getLastKeyPressed(){
		return myCurrentKeyCode != null ? myCurrentKeyCode : null;
	}
	
	//public void addSprite(String aFilepath, int x, int y){
		//mySprites.
	//}
	
	//Send code to back end through controller
	private void handleKeyInput(KeyCode key){
		setChanged();
		myCurrentKeyCode = key;
		notifyObservers();
		clearChanged();
	}

	public void makeRed() {
		myGamePlayCanvas.setStyle("-fx-background-color: red;");
	}

}
