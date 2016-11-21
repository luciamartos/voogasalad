package author.view.pages.sprite.editor;

import java.io.File;

import author.view.util.FileLoader;
import author.view.util.FileLoader.FileType;
import game_data.Location;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class BaseSpriteEditBox {

	private Pane myPane;
	private FileLoader myFileLoader;
	private TextField myXPositionField;
	private TextField myYPositionField;
	private TextField myHeadingField;

	private File myFile;
	
	public BaseSpriteEditBox() {
		myPane = new VBox();
		myFileLoader = new FileLoader(FileType.PNG, FileType.GIF,FileType.JPG, FileType.JPEG);

		myPane.getChildren().addAll(makeLocationFields(), makeImageSelect());	
	}

	public final Pane getPane(){
		return myPane;
	}

	public final Location getLocation(){
		int x, y, h;

		x = Integer.parseInt(myXPositionField.getText());
		y = Integer.parseInt(myYPositionField.getText());
		h = Integer.parseInt(myHeadingField.getText());
		
		return new Location(x, y, h);

	}

	protected final void setLocation(Location aLocation){
		myXPositionField.setText(Double.toString(aLocation.getXLocation()));
		myYPositionField.setText(Double.toString(aLocation.getYLocation()));
		myHeadingField.setText(Double.toString(aLocation.getMyHeading()));
	}
	
	protected final File getImageFile(){
		return myFile;
	}
	
	protected final void setImageFile(File aFile){
		myFile = aFile;
	}
	
	/**
	 * Standing on the shoulders of Evan Knowles
	 * http://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
	 * 
	 * @param aTextField
	 * @return
	 */
	protected final ChangeListener<? super String> makeOnlyNumberProperty(TextField aTextField){
		return (obs, ov, nv) -> { 
			if(!nv.matches("\\d*")) 
				aTextField.setText(nv.replaceAll("[^\\d]", ""));
		}; 

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

	private Node makeImageSelect(){
		Pane imageSelectBox = new HBox();
		
		Button selectButton = new Button("Select Image:");
		ImageView imageView = new ImageView();
		imageView.setFitWidth(100);
		imageView.setFitHeight(100);
		imageSelectBox.getChildren().addAll(selectButton, imageView);
		
		selectButton.setOnMouseClicked(e -> {
			myFile = myFileLoader.loadImage();
			if(myFile != null){
				imageView.setImage(new Image(myFile.toURI().toString()));
			}
		});
		
		return imageSelectBox;
	}
}
