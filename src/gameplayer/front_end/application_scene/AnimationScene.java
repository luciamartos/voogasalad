package gameplayer.front_end.application_scene;
import java.util.Set;

import game_data.Sprite;
import gameplayer.back_end.keycode_handler.KeyCodeHandler;
import gameplayer.front_end.background_display.BackgroundDisplayFactory;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

/**
 * Concrete representation of the scene where games are played
 * 
 * @author tedmarchildon, hannah
 *
 */

public class AnimationScene {
	
	private Pane myGamePlayCanvas;
	private KeyCodeHandler myKeyCodeHandler;
	//private String myBackgroundFilePath;
	
	public AnimationScene(Scene aScene, double aWidth, double aHeight) {
		myGamePlayCanvas = new Pane();
		myKeyCodeHandler = new KeyCodeHandler();
	}
	/**
	 * Add the correct nodes to the scene
	 */
	
	public Pane init() {
		return myGamePlayCanvas;
	}
	
	public void makeRed() {
		myGamePlayCanvas.setStyle("-fx-background-color: red;");
	}
	
	public ImageView addSpriteToScene(Sprite aSprite){
		ImageView image = new ImageView(aSprite.getMyImagePath());
		//hardcode image because image path in xml based off of addison's computer
		//ImageView image = new ImageView("author/images/marioSMBW.png");
		//System.out.println(aSprite.getMyImagePath());
		image.setFitWidth(aSprite.getMyWidth());
		image.setFitHeight(aSprite.getMyHeight());
		//image.setTranslateX(aSprite.getMyLocation().getXLocation());
		//image.setTranslateY(aSprite.getMyLocation().getYLocation());
		image.setX(aSprite.getMyLocation().getXLocation());
		image.setY(aSprite.getMyLocation().getYLocation());
		//System.out.println(image.getX());
		//System.out.println(image.getY());
		//System.out.println(myGamePlayCanvas.getWidth());
		//System.out.println(myGamePlayCanvas.getHeight());
		//System.out.println(myGamePlayCanvas.get);
		myGamePlayCanvas.getChildren().add(image);
		return image;
	}
	
	public void clear() {
		myGamePlayCanvas.getChildren().clear();
	}
	
	public void setBackground(Background aBackground) {
		myGamePlayCanvas.setBackground(aBackground);
	}
	
	public void moveScreen(Set<KeyCode> myKeySet) {
		for (KeyCode key : myKeySet) {
			myGamePlayCanvas.setTranslateX(myGamePlayCanvas.getTranslateX() + myKeyCodeHandler.getMovement(key));
		}
	}
	
}
