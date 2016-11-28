package author.view.pages.sprite;

import java.io.File;
import game_data.Sprite;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SpriteViewBox implements InvalidationListener {

	private Pane myPane;
	private Label myName;
	private Button myImageButton;
	
	private static final String NAME_TEXT = "Name: ";
	private static final String IMG_TEXT = "Click to Edit";
	
	private SpriteViewBox() {
		myPane = new VBox();
		myName = new Label(NAME_TEXT);
		myImageButton = new Button(IMG_TEXT);
		myImageButton.setContentDisplay(ContentDisplay.BOTTOM);
		myPane.getChildren().addAll(myName, myImageButton);		
	}

	public SpriteViewBox(Sprite aSprite){
		this();
		
		myName.setText(NAME_TEXT + aSprite.getName());
		
		ImageView imageView = new ImageView( new Image(new File(aSprite.getMyImagePath()).toURI().toString()));
		imageView.setFitWidth(100);
		imageView.setFitHeight(100);
		myImageButton.setGraphic( imageView );
		myImageButton.setOnMouseClicked( e -> {
			SpriteEditWindow sew = new SpriteEditWindow(aSprite);
			sew.openWindow();
		});
		
		aSprite.addListener(this);
				
	}
	
	public Node getNode(){
		return myPane;
	}

	@Override
	public void invalidated(Observable observable) {
		if(observable instanceof Sprite){
			Sprite s = (Sprite) observable;
			myName.setText(NAME_TEXT + s.getName());
			ImageView iv = new ImageView (new Image(new File(s.getMyImagePath()).toURI().toString()));
			iv.setFitWidth(100);
			iv.setFitHeight(100);
			myImageButton.setGraphic(iv );
		}
	}
	
}
