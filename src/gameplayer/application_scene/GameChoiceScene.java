package gameplayer.application_scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

/**
 * Concrete representation of the scene where users can choose which game to play
 * 
 * @author tedmarchildon, hannah
 *
 */
public class GameChoiceScene extends AbstractPlayerScene {

	public GameChoiceScene(){
		super();
	}

	@Override
	public Scene init(){
		myRoot.setCenter(addNodes());
		return myScene;
	}

	private VBox addNodes() {
		myOptions = new VBox(BOX_INSETS);
		myOptions.setAlignment(Pos.CENTER);
		return myOptions;
	}
}
