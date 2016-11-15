package gameplayer.application_scene;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Concrete representation of the scene where games are played
 * 
 * @author tedmarchildon, hannah
 *
 */

public class GamePlayScene extends AbstractPlayerScene {
	
	private BorderPane myRoot;
	private Pane myGamePlayCanvas;
	
	public GamePlayScene(Stage aStage){
		super(aStage);
	}
	
	/**
	 * Add the correct nodes to the scene
	 */
	
	@Override
	public Scene init(){
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, SCENE_WIDTH, SCENE_HEIGHT);
		myGamePlayCanvas = new Pane();
		myGamePlayCanvas.setStyle("-fx-background-color: blue;");
		myRoot.setCenter(myGamePlayCanvas);
		myRoot.setTop(createTop());
		myRoot.setLeft(createLeft());
		myRoot.setRight(createRight());
		myRoot.setBottom(createBottom());
		myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		return myScene;
	}
	
	//Send code to back end through controller
	private void handleKeyInput(KeyCode key){
		
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
		return createButton("Restart", 0, 0, e -> {
			transitionScene(new SceneFactory().create(myStage, SceneIdentifier.GAMEPLAY.toString()));
		});
	}
	
	private Button createMainMenuButton(){
		return createButton("Main Menu", 0, 0, e -> {
			transitionScene(new SceneFactory().create(myStage, SceneIdentifier.MAINMENU.toString()));
		});
	}
	
	private void addSprite(String aFilepath, int x, int y){
		ImageView spriteRep = new ImageView(aFilepath);
		spriteRep.setTranslateX(x);
		spriteRep.setTranslateY(y);
		myGamePlayCanvas.getChildren().add(spriteRep);
	}
}
