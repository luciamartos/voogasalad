package gameplayer.application_scene;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Concrete representation of the scene where games are played
 * 
 * @author tedmarchildon, hannah
 *
 */

public class GamePlayScene extends AbstractNavigationPlayerScene {
	
	private Pane myGamePlayCanvas;
	private Button myMainMenuButton;
	private Button myRestartButton;
	private KeyCode myCurrentKeyCode = null;
	
	public GamePlayScene(double aWidth, double aHeight){
		super(aWidth, aHeight);
	}
	
	/**
	 * Add the correct nodes to the scene
	 */
	
	@Override
	public Scene init(){
		myGamePlayCanvas = new Pane();
		myRoot.setCenter(myGamePlayCanvas);
		myRoot.setTop(createTop());
		myRoot.setLeft(createLeft());
		myRoot.setRight(createRight());
		myRoot.setBottom(createBottom());
		myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		return myScene;
	}
	
	public void setOnMain(EventHandler<? super MouseEvent> handler){
		myMainMenuButton.setOnMouseClicked(handler);
	}
	
	public void setOnRestart(EventHandler<? super MouseEvent> handler){
		myRestartButton.setOnMouseClicked(handler);
	}
	
	public KeyCode getLastKeyPressed(){
		return myCurrentKeyCode != null ? myCurrentKeyCode : null;
	}
	
	public void addSprite(String aFilepath, int x, int y){
		ImageView spriteRep = new ImageView(aFilepath);
		spriteRep.setTranslateX(x);
		spriteRep.setTranslateY(y);
		myGamePlayCanvas.getChildren().add(spriteRep);
	}
	
	//Send code to back end through controller
	private void handleKeyInput(KeyCode key){
		setChanged();
		myCurrentKeyCode = key;
		notifyObservers();
		clearChanged();
	}

	private Node createTop() {
		HBox topMenu = new HBox(8);
		topMenu.getChildren().addAll(createRestartButton(), createMainMenuButton());
		topMenu.getChildren().add(createButton("Change to red", 0, 0, e -> {
			setBackground(myGamePlayCanvas, Color.RED);
		}));
		topMenu.setAlignment(Pos.CENTER);
		return topMenu;
	}
	
	private Node createLeft(){
		VBox leftMenu = new VBox();
		leftMenu.getChildren().add(createLabel("Left", 0, 0));
		leftMenu.setAlignment(Pos.CENTER);
		return leftMenu;
	}
	
	private Node createRight(){
		VBox rightMenu = new VBox();
		rightMenu.getChildren().add(createLabel("Right", 0, 0));
		rightMenu.setAlignment(Pos.CENTER);
		return rightMenu;
	}
	
	private Node createBottom(){
		HBox bottomMenu = new HBox();
		bottomMenu.getChildren().add(createLabel("Bottom", 0, 0));
		bottomMenu.setAlignment(Pos.CENTER);
		return bottomMenu;
	}
	
	private Button createRestartButton(){
		myRestartButton = createButton("Restart", 0, 0, null);
		return myRestartButton;
	}
	
	private Button createMainMenuButton(){
		myMainMenuButton = createButton("Main Menu", 0, 0, null);
		return myMainMenuButton;
	}
}
