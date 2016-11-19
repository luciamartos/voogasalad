package gameplayer.GUIGenerator;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class GUIGenerator implements IGUIGenerator {
	
	public GUIGenerator() {
		//nothing
	}
	
	public Button createButton(String amessage, int x, int y, EventHandler<? super MouseEvent> ahandler){
		Button newButton = new Button(amessage);
		newButton.setOnMouseClicked(ahandler);
		newButton.setTranslateX(x);
		newButton.setTranslateY(y);
		return newButton;
	}
	
	public TextField createTextField(String aplaceholder, int x, int y, int width){
		TextField newTextField = new TextField(aplaceholder);
		newTextField.setTranslateX(x);
		newTextField.setTranslateY(y);
		newTextField.setMaxWidth(width);
		return newTextField;
	}
	
	public Label createLabel(String atext, int x, int y){
		Label newLabel = new Label(atext);
		newLabel.setTranslateX(x);
		newLabel.setTranslateY(y);
		return newLabel;
	}
	
	//private BackgroundImage createBackgroundImage(String afilepath){
		//return new BackgroundImage(new Image(afilepath, false, true), BackgroundRepeat.REPEAT, 
			//BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	//}
	
	public void setBackground(Pane avalue, String afilepath){
		//avalue.setBackground(new Background(createBackgroundImage(afilepath)));
	}
	
	public void setBackground(Pane avalue, Paint fill){
		avalue.setBackground(new Background(new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY)));
	}

}
