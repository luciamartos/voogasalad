package author.model.game_observables.draggable_sprite;

import java.io.File;

import author.view.pages.sprite.SpriteEditWindow;
import game_data.Sprite;
import javafx.beans.InvalidationListener;
import javafx.scene.Cursor;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

//This entire file is part of my masterpiece.
//Jordan Frazier
/**
 * This abstract class is the framework for making a sprite draggable. The
 * purpose of this class is to provide basic functionality for any sprite that
 * is destined to be represented graphically and granted the ability to be
 * dragged from window to window.
 * This section is well designed because it uses several abstractions, such as this abstract class and the
 * @ResizableSprite interface to pass around only what is necessary for other code to interact successfully.
 * @author Jordan Frazier
 *
 */
public abstract class DraggableSprite {

	/**
	 * These CSS strings alter the DraggableItem Pane when the mouse enters or
	 * exits its boundaries
	 */
	private static final String SPRITE_SELECTED_STYLE = "-fx-border-color: red;" + "-fx-border-width: 1;"
			+ "-fx-border-style: dotted;";
	private static final String SPRITE_DESELECTED_STYLE = "";

	private Pane myDraggableItem;
	private ImageView myImageView;
	private Sprite mySprite;
	private InvalidationListener myInvalidationListener;
	private Boolean isSelected = false;
	private Tooltip myToolTip;

	public DraggableSprite(Sprite aSprite) {
		mySprite = aSprite;
		myDraggableItem = new HBox();
		myImageView = new ImageView(new Image((new File(aSprite.getImagePath()).toURI().toString())));
		addImageToContainer();
		setListener(aSprite);
		openPreferences();
		setOnMouseHover();
	}

	private void addImageToContainer() {
		myDraggableItem.getChildren().add(myImageView);
		myImageView.fitHeightProperty().bind(myDraggableItem.prefHeightProperty());
		myImageView.fitWidthProperty().bind(myDraggableItem.prefWidthProperty());
	}

	public void removeListener() {
		this.mySprite.removeListener(this.myInvalidationListener);
	}

	private void setListener(Sprite aSprite) {
		myInvalidationListener = initListener(aSprite);
		aSprite.addListener(this.myInvalidationListener);
	}

	protected InvalidationListener initListener(Sprite aSprite) {
		InvalidationListener invalidationListener = (sprite) -> {
			this.getImageView().setImage(new Image((new File(aSprite.getImagePath()).toURI().toString())));
		};
		return invalidationListener;
	}

	/**
	 * Opens the Sprite Preferences Dialog, where you can alter characteristics,
	 * states, etc
	 * 
	 * @see SpriteEditWindow
	 */
	protected void openPreferences() {
		myDraggableItem.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				if (e.getClickCount() == 2) {
					new SpriteEditWindow(mySprite).openWindow();
				}
			}
		});
	}

	private void setOnMouseHover() {
		myDraggableItem.setOnMouseEntered(e -> {
			applyCSSSelected();
			displayNameOnHover();
		});
		myDraggableItem.setOnMouseExited(e -> {
			applyCSS(SPRITE_DESELECTED_STYLE);
		});
	}

	public void setSelected() {
		this.isSelected = true;
		applyCSS(SPRITE_SELECTED_STYLE);
	}

	public void setDeselected() {
		this.isSelected = false;
		applyCSS(SPRITE_DESELECTED_STYLE);
	}

	private void applyCSSSelected() {
		myDraggableItem.setCursor(Cursor.HAND);
		applyCSS(SPRITE_SELECTED_STYLE);
	}

	private void applyCSS(String style) {
		myDraggableItem.setStyle(style);
		myDraggableItem.applyCss();
	}

	private void displayNameOnHover() {
		if (myToolTip == null) {
			myToolTip = new Tooltip(mySprite.getName());
		} else {
			myToolTip.setText(mySprite.getName());
		}
		Tooltip.install(myDraggableItem, myToolTip);
	}

	public Pane getDraggableItem() {
		return myDraggableItem;
	}

	public Sprite getSprite() {
		return mySprite;
	}

	public ImageView getImageView() {
		return myImageView;
	}

	/**
	 * Abstract method implemented to remove the preset listener, which prevents
	 * updates to the sprite preset from altering unique instances of the sprite
	 * on the level window
	 */
	public abstract void removePresetListener();
}
