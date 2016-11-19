package gameplayer.application_scene;

import java.io.File;
import java.util.Observable;

import gameplayer.GUIGenerator.GUIGenerator;
import gameplayer.GUIGenerator.IGUIGenerator;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * Representation of generic functionality each scene might need
 * 
 * @author tedmarchildon, hannah
 *
 */
public abstract class AbstractPlayerScene  extends Observable implements IDisplay {
	
	private static final String STYLESHEET = "GUI/style.css";
	private static final String FILE = "file:";
	
	protected Scene myScene;
	protected BorderPane myRoot;
	protected VBox myOptions;
	protected HBox myNavigation;
	protected IGUIGenerator myGUIGenerator; 
	
	public AbstractPlayerScene(double aWidth, double aHeight) {
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, aWidth, aHeight);
		File file = new File(STYLESHEET);
	    myScene.getStylesheets().add(FILE + file.getAbsolutePath());
	    myRoot.setId("pane");
	    myGUIGenerator = new GUIGenerator();
	}
	
	public void addButton(String text, EventHandler<? super MouseEvent> handler){
		myOptions.getChildren().add(myGUIGenerator.createButton(text, 0, 0, handler));
	}
	
	public void addNode(Node node){
		myOptions.getChildren().add(node);
	}

}
