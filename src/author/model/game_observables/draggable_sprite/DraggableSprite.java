package author.model.game_observables.draggable_sprite;

import game_data.Sprite;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * This abstract class is the framework for making a sprite draggable
 * 
 * @author Jordan Frazier
 *
 */
public abstract class DraggableSprite {

	private ImageView myImageView;
	private Sprite mySprite;
	private boolean removable;

	// These define the size of the ghost image that follows the mouse when
	// dragging
	public static final int DRAG_IMAGE_WIDTH = 40;
	public static final int DRAG_IMAGE_HEIGHT = 40;

	public DraggableSprite(Sprite aSprite) {
		setup(aSprite, false);
	}

	public DraggableSprite(Sprite aSprite, boolean removable) {
		setup(aSprite, removable);
	}

	private void setup(Sprite aSprite, boolean removable) {
		mySprite = aSprite;
		this.removable = removable;
		myImageView = new ImageView(new Image(aSprite.getMyImagePath()));
		myImageView.setFitHeight(30);
		myImageView.setFitWidth(30);
		makeDraggable();
		openPreferences();
	}

	private void openPreferences() {
		myImageView.setOnMouseClicked(e -> {
			if(e.getButton().equals(MouseButton.PRIMARY)){
	            if(e.getClickCount() == 2){
	            	// TODO: George(vooga) - Open up the preferences editor
	                System.out.println("Double clicked");
	            }
	        }
		});
	}

	/**
	 * https://docs.oracle.com/javase/8/javafx/events-tutorial/paper-doll.htm#CBHHBAJI
	 */
	protected void makeDraggable() {
		mySprite.setId(this.getClass().getSimpleName() + System.currentTimeMillis());

		myImageView.setOnDragDetected((MouseEvent event) -> {
			Dragboard db = myImageView.startDragAndDrop(TransferMode.MOVE);
			ClipboardContent content = new ClipboardContent();
			// Store the node ID in order to know what is dragged.
			content.putString(mySprite.getId());
			db.setContent(content);
			db.setDragView(new Image(mySprite.getMyImagePath(), DRAG_IMAGE_WIDTH, DRAG_IMAGE_HEIGHT, false, false));
			event.consume();
		});

		myImageView.setOnDragDone(e -> {
			// TODO: Jordan(vooga) - drag - Do not remove from pane. Clone and add to level editor pane. 
			// Update the coordinates of the ObservableSprite with the imageview's position
			// TODO: Jordan(vooga) - change int to double for sprite location when merged
			System.out.println("XMove: " +myImageView.getTranslateX());
			mySprite.getMyLocation().setLocation(myImageView.getTranslateX(), myImageView.getTranslateY());
			e.consume();
		});
	}

	public boolean isRemovable() {
		return removable;
	}

	public ImageView getImageView() {
		return myImageView;
	}
	
	public void setImageView(ImageView imageView) {
		this.myImageView = imageView;
		makeDraggable();
	}
}
