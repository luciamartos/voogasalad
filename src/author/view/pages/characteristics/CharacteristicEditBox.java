package author.view.pages.characteristics;

import author.view.util.BooleanSelector;
import author.view.util.NumberField;
import game_data.characteristics.Characteristic;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

class CharacteristicEditBox {
	
	private Pane myPane;
	private Characteristic myCharacteristic;
	
	private BooleanSelector myBoolSelect;
	
	CharacteristicEditBox() {
		myPane = new VBox();
		myBoolSelect = new BooleanSelector("Boolean Selector");
		NumberField numField = new NumberField("Number Field");
		
		myPane.getChildren().addAll(
				myBoolSelect.getPane(),
				numField.getPane());
	}

	Pane getPane(){
		return myPane;
	}	
	
	Characteristic getCharacteristic(){
		return myCharacteristic;
	}
}
