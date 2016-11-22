package gameplayer.application_scene;

import java.io.File;
import java.util.Observable;

import gameplayer.gui_generator.GUIGenerator;
import gameplayer.gui_generator.IGUIGenerator;
import gameplayer.gui_generator.IGUIGenerator.ButtonDisplay;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Representation of generic functionality each scene might need
 * 
 * @author tedmarchildon, hannah
 *
 */
public abstract class AbstractPlayerScene  extends Observable implements IDisplay {
	
	private static final String STYLESHEET = "data/gui/style.css";
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
	
	public void addButton(String text, EventHandler<? super MouseEvent> handler, ButtonDisplay aButtonDisplayType){
		myOptions.getChildren().add(myGUIGenerator.createButton(text, 0, 0, handler, aButtonDisplayType));
	}
	
	public void addNode(Node node){
		myOptions.getChildren().add(node);
	}
}
