package gameplayer.application_scene;

import gameplayer.button.ButtonFactory;
import gameplayer.button.IButton;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Concrete representation of the scene where users can choose which game to play
 * 
 * @author tedmarchildon, hannah
 *
 */
public class GameChoiceScene extends AbstractPlayerScene {
	
	private Scene myScene;
	private BorderPane myRoot;
	private Node myGameChooserButton;
	
	public GameChoiceScene(){
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, SCENE_WIDTH, SCENE_HEIGHT);
		myButtonBuilder = (IButton) new ButtonFactory();
	}

	@Override
	public Scene init(){
		myRoot.setCenter(addNodes());
		return myScene;
	}

	private VBox addNodes() {
		VBox options = new VBox(BOX_INSETS);
		IButton chooseGameButton = myButtonBuilder.createButton("Choose Game", 0, 0);
		options.getChildren().addAll(myButtonBuilder.createButton("Choose Game", 0, 0, e -> {
			//TODO: Implement choosing games pre-loaded
			//For now it goes to the scene where they will play a game
			transitionScene((new SceneFactory().create(SceneIdentifier.GAMEPLAY)).init()); 
		}), createButton("Load New Game", 0, 0, e -> {
			//TODO: Implement choosing games from the file system
		}));
		options.setAlignment(Pos.CENTER);
		return options;
	}
	
	public Node createChooseGameButton() {
		myGameChooserButton = new Button("Choose Game");
		return myGameChooserButton;
	}
	
	public void setChooseGameButtonClick(EventHandler<? super MouseEvent> aEvent) {
		myGameChooserButton.setOnMouseClicked(aEvent);
	}
	
	
}
