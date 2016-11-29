package gameplayer.front_end.application_scene;
import gameplayer.front_end.gui_generator.GUIGenerator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

/**
 * Concrete representation of the introduction scene
 * 
 * @author tedmarchildon, hannah
 *
 */
public class MainMenuScene extends AbstractNavigationPlayerScene {
	
	private GUIGenerator myCreator;

	public MainMenuScene(double aWidth, double aHeight) {
		super(aWidth, aHeight);
		myCreator = new GUIGenerator();
	}

	@Override
	public Scene init(){
		myRoot.setCenter(addNodes());
		return myScene;
	}
	
	private VBox addNodes(){
		myOptions = new VBox(BOX_INSETS);
		myOptions.getChildren().add(myCreator.createLabel("Let's Just Pray It Works", 0, 0));
		//myOptions.getChildren().addAll(myGUIGenerator.createLabel("Main Menu", 0, 0));
		myOptions.setAlignment(Pos.CENTER);
		return myOptions;
	}
}
