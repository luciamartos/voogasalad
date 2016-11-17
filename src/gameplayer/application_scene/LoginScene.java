package gameplayer.application_scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Login Scene Initiation
 *
 * @author tedmarchildon, hannah
 *
 */
public class LoginScene extends AbstractPlayerScene {

	public LoginScene() {
		super();
	}

	@Override
	public Scene init() {
		myRoot.setCenter(addNodes());
		return myScene;
	}
	
	private VBox addNodes(){
		VBox options = new VBox(BOX_INSETS);
		options.getChildren().add(createTextField("Enter Username", 0, 0, 500));
		options.getChildren().add(createTextField("Enter Password", 0, 0, 500));
		HBox loginOptions = new HBox(BOX_INSETS);
		loginOptions.getChildren().add(createButton("Enter", 0, 0, e -> {
			transitionScene(new SceneFactory().create(SceneIdentifier.MAINMENU));
		}));
		loginOptions.getChildren().add(createButton("Sign Up", 0, 0, e -> {
			//TODO: Implement Signing Up
		}));
		loginOptions.setAlignment(Pos.CENTER);
		options.getChildren().add(loginOptions);
		options.setAlignment(Pos.CENTER);
		return options;
	}
}
