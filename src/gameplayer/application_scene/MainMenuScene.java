package gameplayer.application_scene;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Concrete representation of the introduction scene
 * 
 * @author tedmarchildon, hannah
 *
 */
public class MainMenuScene extends AbstractPlayerScene {

	private Button myPlayButton;
	private Button myAuthorButton;
	private Button mySignOutButton;
	
	public MainMenuScene(){
		super();
	}

	@Override
	public Scene init(){
		myRoot.setCenter(addNodes());
		return myScene;
	}
	
	public void setOnPlay(EventHandler<? super MouseEvent> handler){
		myPlayButton.setOnMouseClicked(handler);
	}
	
	public void setOnAuthor(EventHandler<? super MouseEvent> handler){
		myAuthorButton.setOnMouseClicked(handler);
	}
	
	public void setOnSignOut(EventHandler<? super MouseEvent> handler){
		mySignOutButton.setOnMouseClicked(handler);
	}
	
	private VBox addNodes(){
		VBox options = new VBox(BOX_INSETS);
		options.getChildren().addAll(createLabel("Main Menu", 0, 0));
		myPlayButton = createButton("Click to Play", 0, 0, null);
		options.getChildren().add(myPlayButton);
		myAuthorButton = createButton("Click to Author", 0, 0, null);
		options.getChildren().add(myAuthorButton);
		mySignOutButton = createButton("Sign Out", 0, 0, null);
		options.getChildren().add(mySignOutButton);
		options.setAlignment(Pos.CENTER);
		return options;
	}
}
