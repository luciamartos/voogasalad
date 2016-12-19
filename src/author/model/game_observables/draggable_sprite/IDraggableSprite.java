package author.model.game_observables.draggable_sprite;

import game_data.Sprite;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
//This entire file is part of my masterpiece.
//Jordan Frazier
/**
 * This interface defines the behavior for an abstract DraggableSprite
 * @author Jordan Frazier
 *
 */
public interface IDraggableSprite extends ISpritePresetListener {
	/**
	 * Sets the Sprite to selected. Used when selecting multiple Sprites at once.
	 */
	public void setSelected();
	/**
	 * Sets the Sprite to deselected
	 */
	public void setDeselected();
	/**
	 * Gets the container of the Sprite's ImageView
	 * @return Pane
	 */
	public Pane getDraggableItem();
	/**
	 * Gets the ImageView representing the Sprite
	 * @return ImageView
	 */
	public ImageView getImageView();
	/**
	 * Gets the Game Data Sprite
	 * @return
	 */
	public Sprite getSprite();

}
