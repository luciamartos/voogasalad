package gameplayer.application_scene;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Concrete representation of the introduction scene
 * 
 * @author tedmarchildon, hannah
 *
 */
public class MainMenuScene extends AbstractPlayerScene {

	public MainMenuScene(Stage aStage){
		super(aStage);
	}

	@Override
	public Scene init(){
		myRoot.setCenter(addNodes());
		return myScene;
	}	
	
	private VBox addNodes(){
		VBox options = new VBox(BOX_INSETS);
		options.getChildren().addAll(createLabel("Main Menu", 0, 0),
				createButton("Click to Play", 0, 0, e -> {
					transitionScene(new GameChoiceScene(myStage));
				}),
				createButton("Click to Author", 0, 0, e -> {
					//TODO: Implement transition to authoring environment
				}),
				createButton("Background Test", 0, 0, e -> {
					setBackground(myRoot, Color.BLACK);
				}),
				createButton("Sign Out", 0, 0, e -> {
					transitionScene(new LoginScene(myStage));
				})
		);
		options.setAlignment(Pos.CENTER);
		return options;
	}
}
