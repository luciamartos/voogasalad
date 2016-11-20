package gameplayer.application_scene;


import java.util.Observable;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

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

//	private Node createTop() {
//		HBox topMenu = new HBox(8);
////		topMenu.getChildren().addAll(createRestartButton(), createMainMenuButton());
//		topMenu.getChildren().add(createButton("Change to red", 0, 0, e -> {
//			setBackground(myGamePlayCanvas, Color.RED);
//		}));
//		topMenu.setAlignment(Pos.CENTER);
//		return topMenu;
//	}
//	
//	private Node createLeft(){
//		VBox leftMenu = new VBox();
//		leftMenu.getChildren().add(createLabel("Left", 0, 0));
//		leftMenu.setAlignment(Pos.CENTER);
//		return leftMenu;
//	}
//	
//	private Node createRight(){
//		VBox rightMenu = new VBox();
//		rightMenu.getChildren().add(createLabel("Right", 0, 0));
//		rightMenu.setAlignment(Pos.CENTER);
//		return rightMenu;
//	}
//	
//	private Node createBottom(){
//		HBox bottomMenu = new HBox();
//		bottomMenu.getChildren().add(createLabel("Bottom", 0, 0));
//		bottomMenu.setAlignment(Pos.CENTER);
//		return bottomMenu;
//	}
	
//	private Button createRestartButton(){
//		myRestartButton = createButton("Restart", 0, 0, null);
//		return myRestartButton;
//	}
//	
//	private Button createMainMenuButton(){
//		myMainMenuButton = createButton("Main Menu", 0, 0, null);
//		return myMainMenuButton;
//	}
	public void makeRed() {
		myGamePlayCanvas.setStyle("-fx-background-color: red;");
	}

}
