package author.model.game_observables.draggable_sprite;

/**
 * This interface defines behavior for Sprites that implement listeners
 * @author Jordan Frazier
 *
 */
public interface ISpritePresetListener {

	/**
	 * Removes the Preset listener from the Sprite which decouples the Sprite from the Preset Sprite
	 */
	public void removePresetListener();
	/**
	 * Removes the listener on a deleted Sprite for memory management
	 */
	public void removeListener();
	
}
