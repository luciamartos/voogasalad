package gameplayer.application_scene;

import java.io.File;
import java.util.Observable;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * Representation of generic functionality each scene might need
 * 
 * @author tedmarchildon, hannah
 *
 */
public abstract class AbstractPlayerScene extends Observable implements IDisplay {
	
	private static final String STYLESHEET = "GUI/style.css";
	private static final String FILE = "file:";
	
	protected Scene myScene;
	protected BorderPane myRoot;
	protected VBox myOptions;
	
	public AbstractPlayerScene(double aWidth, double aHeight) {
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, aWidth, aHeight);
		File file = new File(STYLESHEET);
	    myScene.getStylesheets().add(FILE + file.getAbsolutePath());
	    myRoot.setId("pane");
	    
	}
	
	public void addButton(String text, EventHandler<? super MouseEvent> handler){
		myOptions.getChildren().add(createButton(text, 0, 0, handler));
	}
	
	protected Button createButton(String amessage, int x, int y, EventHandler<? super MouseEvent> ahandler){
		Button newButton = new Button(amessage);
		newButton.setOnMouseClicked(ahandler);
		newButton.setTranslateX(x);
		newButton.setTranslateY(y);
		return newButton;
	}
	
	protected TextField createTextField(String aplaceholder, int x, int y, int width){
		TextField newTextField = new TextField(aplaceholder);
		newTextField.setTranslateX(x);
		newTextField.setTranslateY(y);
		newTextField.setMaxWidth(width);
		return newTextField;
	}
	
	protected Label createLabel(String atext, int x, int y){
		Label newLabel = new Label(atext);
		newLabel.setTranslateX(x);
		newLabel.setTranslateY(y);
		return newLabel;
	}
	
	//private BackgroundImage createBackgroundImage(String afilepath, double aWidth, aHeight){
		//return new BackgroundImage(new Image(afilepath, aWidth, aHeight, false, true), BackgroundRepeat.REPEAT, 
			//	BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	//}
	
	//protected void setBackground(Pane avalue, String afilepath){
		//avalue.setBackground(new Background(createBackgroundImage(afilepath)));
	//}
	
	protected void setBackground(Pane avalue, Paint fill){
		avalue.setBackground(new Background(new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
