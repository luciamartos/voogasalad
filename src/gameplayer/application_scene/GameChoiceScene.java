package gameplayer.application_scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Concrete representation of the scene where users can choose which game to play
 * 
 * @author tedmarchildon, hannah
 *
 */
public class GameChoiceScene extends AbstractPlayerScene {

	public GameChoiceScene(Stage aStage){
		super(aStage);
	}

	@Override
	public Scene init(){
		myRoot.setCenter(addNodes());
		return myScene;
	}

	private VBox addNodes() {
		VBox options = new VBox(BOX_INSETS);
		options.getChildren().addAll(createButton("Choose Game", 0, 0, e -> {
			//TODO: Implement choosing games pre-loaded
			//For now it goes to the scene where they will play a game
			transitionScene(new PlayerScene(myStage));
		}), createButton("Load New Game", 0, 0, e -> {
			//TODO: Implement choosing games from the file system
		}));
		options.setAlignment(Pos.CENTER);
		return options;
	}
}
