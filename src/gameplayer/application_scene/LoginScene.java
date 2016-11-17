package gameplayer.application_scene;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Login Scene Initiation
 *
 * @author tedmarchildon, hannah
 *
 */
public class LoginScene extends AbstractPlayerScene {

	private VBox myOptions;
	private HBox myLoginOptions;
	
	public LoginScene() {
		super();
	}
	
	@Override
	public void addButton(String text, EventHandler<? super MouseEvent> handler){
		myLoginOptions.getChildren().add(createButton(text, 0, 0, handler));
	}

	@Override
	public Scene init() {
		myRoot.setCenter(addNodes());
		return myScene;
	}
	
	private VBox addNodes(){
		myOptions = new VBox(BOX_INSETS);
		myLoginOptions = new HBox(BOX_INSETS);
		myOptions.getChildren().add(createTextField("Enter Username", 0, 0, 500));
		myOptions.getChildren().add(createTextField("Enter Password", 0, 0, 500));
		myLoginOptions.setAlignment(Pos.CENTER);
		myOptions.getChildren().add(myLoginOptions);
		myOptions.setAlignment(Pos.CENTER);
		return myOptions;
	}
}
