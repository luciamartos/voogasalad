package author.view.util;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class NumberField {

	private Pane myPane;
	private Label myLabel;
	private TextField myTextField;
	
	private static final int SPACING = 5;
	
	public NumberField() {
		myTextField = new TextField();
		myTextField.textProperty().addListener(makeOnlyNumberProperty());
		
		myLabel = new Label();
		
		myPane = new HBox(SPACING);
		myPane.getChildren().addAll(myLabel, myTextField);
		HBox.setHgrow(myTextField, Priority.ALWAYS);
	}

	public NumberField(String aText) {
		this();
		myLabel.setText(aText);
	}
	
	public int getInteger(){
		Integer x;
		
		try {
			x = Integer.parseInt(myTextField.getText());	
		} catch (NumberFormatException e){
			x = 0;
		}
		
		return x;
	}
	
	public double getDouble(){
		Double x;
		
		try {
			x = Double.parseDouble(myTextField.getText()); 
		} catch (NumberFormatException e) {
			x = 0.0;
		}
		
		return x;
	}
	
	public void setValue(Number aNumber){
		myTextField.setText(aNumber.toString());
	}
	
	public Pane getPane(){
		return myPane;
	}
	
	
	
	/**
	 * Standing on the shoulders of Evan Knowles and limc here
	 * http://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
	 * http://stackoverflow.com/questions/5011855/matching-decimals-in-strings-using-matcher
	 * 
	 * @param aTextField
	 * @return
	 */
	private final ChangeListener<? super String> makeOnlyNumberProperty(){
		return (obs, ov, nv) -> { 
			if(!nv.matches("\\d+(\\.\\d+)")){
				myTextField.setText(nv.replaceAll("[^\\d+(\\.\\d+)]", ""));
			}
		}; 

	}
	
}
