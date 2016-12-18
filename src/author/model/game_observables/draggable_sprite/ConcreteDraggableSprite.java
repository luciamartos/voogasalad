package author.model.game_observables.draggable_sprite;

import game_data.Sprite;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
//This entire file is part of my masterpiece.
//Jordan Frazier
/**
 * The concrete implementation that populates the @EntityWindow. 
 * Makes sprites draggable from the window and populates the dragboard and clipboard with the ID. 
 * @author Jordan Frazier
 *
 */
public class ConcreteDraggableSprite extends DraggableSprite {

	public ConcreteDraggableSprite(Sprite aSprite) {
		super(aSprite);
		makeDraggable();
	}

	/**
	 * https://docs.oracle.com/javase/8/javafx/events-tutorial/paper-doll.htm#CBHHBAJI
	 */
	protected void makeDraggable() {
		getDraggableItem().setOnDragDetected((MouseEvent event) -> {
			getSprite().setId(this.getClass().getSimpleName() + System.currentTimeMillis());
			Dragboard db = getImageView().startDragAndDrop(TransferMode.MOVE);
			ClipboardContent content = new ClipboardContent();
			// Store the node ID in order to know what is dragged.
			content.putString(getSprite().getId());
			db.setContent(content);
			db.setDragView(new Text(getSprite().getName()).snapshot(null, null), event.getX(), event.getY());
			event.consume();
		});
	}

	@Override
	public void removePresetListener() {
		// Does nothing, as this sprite does not have a preset listener
	}
}