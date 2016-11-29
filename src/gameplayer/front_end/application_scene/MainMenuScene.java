package gameplayer.front_end.application_scene;
import gameplayer.front_end.animated_display.AnimatedTitleDisplay;
import gameplayer.front_end.gui_generator.GUIGenerator;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Concrete representation of the introduction scene
 * 
 * @author tedmarchildon, hannah
 *
 */
public class MainMenuScene extends AbstractNavigationPlayerScene {
	
	//private GUIGenerator myCreator;
	private AnimatedTitleDisplay myTitle;
	private Pane myPane; 
	private double myWidth;
	private double myHeight;

	public MainMenuScene(double aWidth, double aHeight) {
		super(aWidth, aHeight);
		//myCreator = new GUIGenerator();
		myPane = new Pane();
		myTitle = new AnimatedTitleDisplay();
		myWidth = aWidth;
		myHeight = aHeight;
	}

	@Override
	public Scene init() {
		HBox title = myTitle.buildAnimatedTitleDisplay();
		title.prefHeightProperty().bind(myPane.heightProperty());
		title.prefWidthProperty().bind(myPane.widthProperty());
		title.setLayoutX(myWidth / 3);
		title.setLayoutY(myHeight / 3);
		myPane.getChildren().add(title);
		
		myPane.getChildren().add(addNodes());
		myRoot.setCenter(myPane);
		return myScene;
	}
	
	private VBox addNodes() {
		myOptions = new VBox(BOX_INSETS);
		myOptions.prefHeightProperty().bind(myPane.heightProperty());
		myOptions.prefWidthProperty().bind(myPane.widthProperty());
		myOptions.setLayoutX(0);
		myOptions.setLayoutY(myHeight / 8);
		myOptions.setAlignment(Pos.CENTER);
		return myOptions;
	}
}
