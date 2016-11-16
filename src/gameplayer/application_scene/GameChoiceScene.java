package gameplayer.application_scene;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Concrete representation of the scene where users can choose which game to play
 * 
 * @author tedmarchildon, hannah
 *
 */
public class GameChoiceScene extends AbstractPlayerScene {

	private Button myChoiceButton;
	private Button myLoadButton;
	
	public GameChoiceScene(){
		super();
	}

	@Override
	public Scene init(){
		myRoot.setCenter(addNodes());
		return myScene;
	}
	
	public void setOnChoose(EventHandler<? super MouseEvent> handler){
		myChoiceButton.setOnMouseClicked(handler);
	}
	
	public void setOnLoad(EventHandler<? super MouseEvent> handler){
		myLoadButton.setOnMouseClicked(handler);
	}

	private VBox addNodes() {
		VBox options = new VBox(BOX_INSETS);
		myChoiceButton = createButton("Choose Game", 0, 0, null);
		options.getChildren().add(myChoiceButton);
		myLoadButton = createButton("Load New Game", 0, 0, null);
		options.getChildren().add(myLoadButton);
		options.setAlignment(Pos.CENTER);
		return options;
	}
}
