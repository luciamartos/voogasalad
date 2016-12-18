package author.model.game_observables.draggable_sprite;

import game_data.Sprite;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
//This entire file is part of my masterpiece.
//Jordan Frazier
/**
 * This interface is the abstraction passed into the @DragResizeMod. I chose to create this interface
 * specifically for this purpose in order to hide details of the DraggableSprite from the DragResizeMod.
 * @author Jordan Frazier
 *
 */
public interface ResizableSprite {

	/**
	 * Returns the Pane which holds the ImageView inside of it
	 * @return Pane
	 */
	Pane getDraggableItem();
	
	/**
	 * The ImageView representing the sprite
	 * @return ImageView
	 */
	ImageView getImageView();
	
	/**
	 * The back end sprite, which lives in Game Data
	 * @return
	 */
	Sprite getSprite();
	
}
