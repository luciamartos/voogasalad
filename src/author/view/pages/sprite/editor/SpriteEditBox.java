package author.view.pages.sprite.editor;

import java.io.File;

import author.view.util.FileLoader;
import author.view.util.FileLoader.FileType;
import game_data.Location;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

class SpriteEditBox {

	private Pane myPane;
	private FileLoader myFileLoader;
	private TextField myXPositionField;
	private TextField myYPositionField;
	private TextField myHeadingField;
	private ImageView myImageView;
	private File myFile;
	
	private static final double CHAR_SIZE = 100;
	
	SpriteEditBox() {
		myPane = new HBox();
		myFile = new File("");
		myFileLoader = new FileLoader(FileType.GIF, FileType.PNG, FileType.JPG, FileType.JPEG);

		myPane.getChildren().addAll(makeLocationFields(), makeImageSelect());	
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

	void setLocation(Location aLocation){
		myXPositionField.setText(Double.toString(aLocation.getXLocation()));
		myYPositionField.setText(Double.toString(aLocation.getYLocation()));
		myHeadingField.setText(Double.toString(aLocation.getMyHeading()));
	}
	
	File getImageFile(){
		return myFile;
	}
	
	void setImageFile(File aFile){
		myFile = aFile;
		myImageView.setImage(new Image(myFile.toURI().toString()));
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

	private Node makeLocationFields(){
		Pane locationBox = new VBox();

		Pane xBox = new HBox();
		myXPositionField = new TextField();
		xBox.getChildren().addAll(new Label("X: "), myXPositionField);
		
		Pane yBox = new HBox();
		myYPositionField = new TextField();
		yBox.getChildren().addAll(new Label("Y: "), myYPositionField);
		
		myHeadingField = new TextField();
		Pane hBox = new HBox();
		hBox.getChildren().addAll(new Label("Angle:"), myHeadingField);
		
		HBox.setHgrow(myXPositionField, Priority.ALWAYS);
		HBox.setHgrow(myYPositionField, Priority.ALWAYS);
		HBox.setHgrow(myHeadingField, Priority.ALWAYS);

		
		Pane coordinateBox = new VBox();
		coordinateBox.getChildren().addAll(xBox, yBox, hBox);
			
		myXPositionField.textProperty().addListener( makeOnlyNumberProperty(myXPositionField) );
		myYPositionField.textProperty().addListener( makeOnlyNumberProperty(myYPositionField) );
		myHeadingField.textProperty().addListener( makeOnlyNumberProperty(myHeadingField) );
		
		locationBox.getChildren().addAll(
				new Label("Location: "),
				coordinateBox
				);

		return locationBox;
	}

	private Node makeImageSelect(){
		Pane imageSelectBox = new HBox();
		
		myImageView = new ImageView();
		Button imageButton = new Button();
		imageButton.setText("Select Image:");
		imageButton.setContentDisplay(ContentDisplay.TOP);
		imageButton.setGraphic(myImageView);
		
		
		myImageView.setFitWidth(CHAR_SIZE);
		myImageView.setFitHeight(CHAR_SIZE);
		
		imageSelectBox.getChildren().addAll(imageButton, myImageView);
		
		imageButton.setOnMouseClicked(e -> {
			myFile = myFileLoader.loadImage();
			if(myFile != null){
				myImageView.setImage(new Image(myFile.toURI().toString()));
			}
		});
		
		return imageSelectBox;
	}
}
