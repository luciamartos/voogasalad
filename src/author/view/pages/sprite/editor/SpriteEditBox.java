package author.view.pages.sprite.editor;

import game_data.Location;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

class SpriteEditBox {

	private Pane myPane;
	private TextField myXPositionField;
	private TextField myYPositionField;
	private TextField myHeadingField;

	SpriteEditBox() {
		myPane = new VBox();
		myPane.getChildren().addAll(makeLocationFields());		
	}

	private Node makeLocationFields(){
		Pane locationBox = new HBox();

		myXPositionField = new TextField();
		myYPositionField = new TextField();
		myHeadingField = new TextField();
		
		myXPositionField.textProperty().addListener( makeOnlyNumberProperty(myXPositionField) );
		myYPositionField.textProperty().addListener( makeOnlyNumberProperty(myYPositionField) );
		myHeadingField.textProperty().addListener( makeOnlyNumberProperty(myHeadingField) );
		
		locationBox.getChildren().addAll(
				new Label("Location: "),
				new Label("X: "),
				myXPositionField,
				new Label("Y: "),
				myYPositionField,
				new Label("Heading: "),
				this.myHeadingField
				);

		return locationBox;
	}

	Pane getPane(){
		return myPane;
	}

	Location getLocation(){
		int x, y, h;

		x = Integer.parseInt(myXPositionField.getText());
		y = Integer.parseInt(myYPositionField.getText());
		h = Integer.parseInt(myHeadingField.getText());
		
		return new Location(x, y, h);

	}

	/**
	 * Standing on the shoulders of Evan Knowles
	 * http://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
	 * 
	 * @param aTextField
	 * @return
	 */
	private ChangeListener<? super String> makeOnlyNumberProperty(TextField aTextField){
		return (obs, ov, nv) -> { 
			if(!nv.matches("\\d*")) 
				aTextField.setText(nv.replaceAll("[^\\d]", ""));
		}; 

	}

}
