package gameplayer.front_end.application_scene;
import game_data.Sprite;
import gameplayer.front_end.background_display.BackgroundDisplayFactory;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
	
	public AnimationScene(Scene aScene, double aWidth, double aHeight) {
		myGamePlayCanvas = new Pane();
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
		image.setFitWidth(aSprite.getMyWidth());
		image.setFitHeight(aSprite.getMyHeight());
		image.setTranslateX(aSprite.getMyLocation().getXLocation());
		image.setTranslateY(aSprite.getMyLocation().getYLocation());
		myGamePlayCanvas.getChildren().add(image);
		return image;
	}
	
	public void setBackground(String aFilePath, int aWidth, int aHeight){
		Background backgroundDisplay = new BackgroundDisplayFactory().buildBackgroundDisplay(aFilePath, aWidth, aHeight);
		myGamePlayCanvas.setBackground(backgroundDisplay);
	}
}
