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

public class BaseSpriteEditBox {

	private Pane myPane;
	private FileLoader myFileLoader;
	private TextField myXPositionField;
	private TextField myYPositionField;
	private TextField myHeadingField;
	private TextField myNameField;
	private TextField myWidthField;
	private TextField myHeightField;
	private ImageView myImageView;
	private String myImagePath;
	
	private static final double CHAR_SIZE = 100;
	
	public BaseSpriteEditBox() {
		myPane = new VBox();
		myFileLoader = new FileLoader(FileType.PNG, FileType.GIF,FileType.JPG, FileType.JPEG);
		myPane.getChildren().addAll(makeNameField(), makeLocationFields(),makeSizeFields(), makeImageSelect());	
	}

	public final Pane getPane(){
		return myPane;
	}

	public final String getName(){
		return myNameField.getText();
	}
	
	public final void setName(String aName){
		myNameField.setText(aName);		
	}
	
	public final void setSize(int aWidth, int aHeight){
		myWidthField.setText("" + aWidth);
		myHeightField.setText("" + aHeight);
	}
	
	public final int getWidth(){
		int width;
		
		try {
			width = Integer.parseInt(myWidthField.getText());
		}
		catch (NumberFormatException e){
			width = 0;
		} 
		
		return width;
	}
	
	public final int getHeight(){
		int height;
		
		try {
			height = Integer.parseInt(myHeightField.getText());
		}
		catch (NumberFormatException e){
			height = 0;
		} 
		
		return height;
	}
	
	public final Location getLocation(){
		Double x, y, h;
		
		try {
			x = Double.parseDouble(myXPositionField.getText());
		} catch (Exception e) {
			x = 0.0;
		}
		
		try {
			y = Double.parseDouble(myYPositionField.getText());
		} catch (Exception e) {
			y = 0.0;
		}
		
		try {
			h = Double.parseDouble(myHeadingField.getText());
		} catch (Exception e){
			h = 0.0;
		}
		
		return new Location(x, y, h);

	}

	protected final void setLocation(Location aLocation){
		myXPositionField.setText(Double.toString(aLocation.getXLocation()));
		myYPositionField.setText(Double.toString(aLocation.getYLocation()));
		myHeadingField.setText(Double.toString(aLocation.getMyHeading()));
	}
	
	protected final String getImageFile(){
		return myImagePath;
	}
	
	protected final void setImageFile(String aImagePath){
		myImagePath = aImagePath;
		myImageView.setImage(new Image( myImagePath ));
	}
	
	/**
	 * Standing on the shoulders of Evan Knowles and limc here
	 * http://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
	 * http://stackoverflow.com/questions/5011855/matching-decimals-in-strings-using-matcher
	 * 
	 * @param aTextField
	 * @return
	 */
	protected final ChangeListener<? super String> makeOnlyNumberProperty(TextField aTextField){
		return (obs, ov, nv) -> { 
			if(!nv.matches("\\d+(\\.\\d+)")){
				aTextField.setText(nv.replaceAll("[^\\d+(\\.\\d+)]", ""));
			}
		}; 

	}

	private Node makeNameField(){
		Pane nameBox = new VBox();
		
		myNameField = new TextField();
		nameBox.getChildren().addAll(new Label("Name: "), myNameField);
		HBox.setHgrow(myNameField, Priority.ALWAYS);
		
		return nameBox;
	}
	
	private Node makeSizeFields(){
		Pane sizeBox = new VBox();
		
		Pane wBox = new HBox();
		myWidthField = new TextField();
		myWidthField.textProperty().addListener(makeOnlyNumberProperty(myWidthField));;
		wBox.getChildren().addAll(new Label("Width: "), myWidthField);
		HBox.setHgrow(myWidthField, Priority.ALWAYS);

		
		Pane hBox = new HBox();
		myHeightField = new TextField();
		myHeightField.textProperty().addListener(makeOnlyNumberProperty(myHeightField));;
		hBox.getChildren().addAll(new Label("Height: "), myHeightField);
		HBox.setHgrow(myHeightField, Priority.ALWAYS);

		sizeBox.getChildren().addAll( new Label("Size: "), wBox, hBox);		
		
		return sizeBox;
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
		Pane hBox = new VBox();
		hBox.getChildren().addAll(new Label("Angle: "), myHeadingField);
		
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
			File file = myFileLoader.loadImage();
			if(file != null){
				myImagePath = file.toURI().toString();
				myImageView.setImage(new Image(myImagePath));
			}
		});
		
		return imageSelectBox;
	}
}
