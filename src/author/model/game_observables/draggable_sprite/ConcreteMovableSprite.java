package author.model.game_observables.draggable_sprite;

import java.io.File;

import author.model.game_observables.draggable_sprite.drag_resize.DragResizeMod;
import author.view.pages.sprite.SpriteEditWindow;
import game_data.Location;
import game_data.Sprite;
import javafx.beans.InvalidationListener;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;

//This entire file is part of my masterpiece.
//Jordan Frazier
/**
 * Extension of DraggableSprite. This class defines the functionality of the
 * sprites that are actually placed on the level editor. Allows users to click
 * and drag sprites around the level editor, along with other functionality.
 * 
 * @author Jordan Frazier
 *
 */
public class ConcreteMovableSprite extends DraggableSprite implements ResizableSprite {

	private Sprite mySpritePreset;
	private InvalidationListener myPresetInvalidationListener;

	public ConcreteMovableSprite(Sprite aSpriteInstance, Sprite aSpritePreset) {
		super(aSpriteInstance);
		mySpritePreset = aSpritePreset;
		myPresetInvalidationListener = mySpritePreset == null ? null
				: initPresetListener(aSpriteInstance, mySpritePreset);
		styleSprite();
		makeSpriteResizable();
	}

	/**
	 * Passes in a ResizableSprite to the @DragResizeMod that gives the
	 * DraggableItem the resizable functionality
	 */
	private void makeSpriteResizable() {
		DragResizeMod resizer = new DragResizeMod(this, this.getDraggableItem(), mySpritePreset,
				myPresetInvalidationListener, null);
		resizer.makeResizable(this.getDraggableItem(), null);
	}

	/**
	 * Removes the listener for garbage collection to avoid memory
	 * over-allocation
	 */
	public void removePresetListener() {
		if (mySpritePreset != null) {
			mySpritePreset.removeListener(myPresetInvalidationListener);
			this.getSprite().setPreset(null);
		}
	}

	private void styleSprite() {
		getDraggableItem().setLayoutX(getSprite().getLocation().getXLocation());
		getDraggableItem().setLayoutY(getSprite().getLocation().getYLocation());
		getDraggableItem().setPrefWidth(getSprite().getWidth());
		getDraggableItem().setPrefHeight(getSprite().getHeight());
	}

	@Override
	protected void openPreferences() {
		this.getDraggableItem().setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				if (e.getClickCount() == 2) {
					removePresetListener();
					new SpriteEditWindow(this.getSprite()).openWindow();
				}
			}
		});
	}

	/**
	 * Creates a listener for the Sprite preset, so when the preset is changed,
	 * all instances of this sprite on the level are altered unless the listener
	 * has been removed.
	 * 
	 * @param instanceSprite
	 * @param spritePreset
	 * @return
	 */
	private InvalidationListener initPresetListener(Sprite instanceSprite, Sprite spritePreset) {
		InvalidationListener invalidationListener = (sprite) -> {
			instanceSprite.setImagePath(spritePreset.getImagePath());
			instanceSprite.setWidth(spritePreset.getWidth());
			instanceSprite.setHeight(spritePreset.getHeight());
			spritePreset.getCharacteristics()
					.forEach((characteristic) -> instanceSprite.addCharacteristic(characteristic));
		};
		spritePreset.addListener(invalidationListener);
		return invalidationListener;
	}

	/**
	 * The sprite listener, which relocates the draggable item's image, size,
	 * and width to match the sprite's
	 */
	@Override
	protected InvalidationListener initListener(Sprite aSprite) {
		InvalidationListener invalidationListener = (sprite) -> {
			this.getImageView().setImage(new Image((new File(aSprite.getImagePath()).toURI().toString())));
			this.getDraggableItem().setPrefWidth(aSprite.getWidth());
			this.getDraggableItem().setPrefHeight(aSprite.getHeight());
			this.getDraggableItem().relocate(aSprite.getLocation().getXLocation(),
					aSprite.getLocation().getYLocation());
		};
		return invalidationListener;
	}

}
