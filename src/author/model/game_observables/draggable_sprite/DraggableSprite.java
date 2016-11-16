package author.model.game_observables.draggable_sprite;

import author.model.game_observables.observable_sprite.ObservableSprite;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
/**
 * 
 * @author Jordan Frazier
 *
 */
public abstract class DraggableSprite {

	private ImageView myImageView;
	private ObservableSprite mySprite;
	
	// These define the size of the ghost image that follows the mouse when dragging
	public static final int DRAG_IMAGE_WIDTH = 40;
	public static final int DRAG_IMAGE_HEIGHT = 40;

	public DraggableSprite(ObservableSprite sprite) {
		mySprite = sprite;
		myImageView = new ImageView(new Image(sprite.getMyImagePath()));
		makeDraggable();
	}

	private void makeDraggable() {
		myImageView.setOnDragDetected(e -> {
			System.out.println("onDragDetected");
			Dragboard db = myImageView.startDragAndDrop(TransferMode.ANY);
			// ClipboardContent content = new ClipboardContent();
			// content.putString(source.getText());
			// db.setContent(content);
			db.setDragView(new Image(mySprite.getMyImagePath(), DRAG_IMAGE_WIDTH, DRAG_IMAGE_HEIGHT, false, false));
			e.consume();
		});

		myImageView.setOnDragDone(e -> {
			// TODO: Jordan - drag - Do not remove from pane. Clone and add to level editor pane. 
			// Update the coordinates of the ObservableSprite with the imageview's position
			mySprite.getMyLocation().setLocation(myImageView.getTranslateX(), myImageView.getTranslateY());
			e.consume();
		});
	}

	public ImageView getImageView() {
		return myImageView;
	}
}
