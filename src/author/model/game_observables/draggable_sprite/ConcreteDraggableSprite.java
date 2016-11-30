package author.model.game_observables.draggable_sprite;

import game_data.Sprite;
/**
 * 
 * @author Jordan Frazier
 *
 */
public class ConcreteDraggableSprite extends DraggableSprite {

	public ConcreteDraggableSprite(Sprite sprite) {
		super(sprite);
	}
	
	public ConcreteDraggableSprite(Sprite sprite, boolean removable) {
		super(sprite, removable);
	}

}
