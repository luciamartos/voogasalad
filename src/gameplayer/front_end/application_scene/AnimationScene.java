package gameplayer.front_end.application_scene;
import javafx.scene.Scene;
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

}