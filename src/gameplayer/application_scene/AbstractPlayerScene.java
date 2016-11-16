package gameplayer.application_scene;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

/**
 * Representation of generic functionality each scene might need
 * 
 * @author tedmarchildon, hannah
 *
 */
public abstract class AbstractPlayerScene implements IDisplay {
	
	protected Scene myScene;
	protected BorderPane myRoot;
	
	public AbstractPlayerScene(){
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, SCENE_WIDTH, SCENE_HEIGHT);
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
	
	private BackgroundImage createBackgroundImage(String afilepath){
		return new BackgroundImage(new Image(afilepath, SCENE_WIDTH, SCENE_HEIGHT, false, true), BackgroundRepeat.REPEAT, 
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	}
	
	protected void setBackground(Pane avalue, String afilepath){
		avalue.setBackground(new Background(createBackgroundImage(afilepath)));
	}
	
	protected void setBackground(Pane avalue, Paint fill){
		avalue.setBackground(new Background(new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
