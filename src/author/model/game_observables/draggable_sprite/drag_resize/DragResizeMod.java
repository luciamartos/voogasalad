package author.model.game_observables.draggable_sprite.drag_resize;

import author.model.game_observables.draggable_sprite.ResizableSprite;
import author.view.pages.sprite.SpriteEditWindow;
import game_data.Location;
import game_data.Sprite;
import javafx.beans.InvalidationListener;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

/**
 * 
 * https://github.com/varren/JavaFX-Resizable-Draggable-Node/blob/master/src/sample/DragResizeMod.java
 * 
 *  ************* How to use ************************
 *
 * Rectangle rectangle = new Rectangle(50, 50);
 * rectangle.setFill(Color.BLACK);
 * DragResizeMod.makeResizable(rectangle, null);
 *
 * Pane root = new Pane();
 * root.getChildren().add(rectangle);
 *
 * primaryStage.setScene(new Scene(root, 300, 275));
 * primaryStage.show();
 *
 * ************* OnDragResizeEventListener **********
 *
 * You need to override OnDragResizeEventListener and
 * 1) preform out of main field bounds check
 * 2) make changes to the node
 * (this class will not change anything in node coordinates)
 *
 * There is defaultListener and it works only with Canvas nad Rectangle
 */

/**
 * Modified class to work with our sprites (jf)
 * 
 * @author https://github.com/varren/JavaFX-Resizable-Draggable-Node/blob/master/src/sample/DragResizeMod.java
 * 
 */
public class DragResizeMod {
	public interface OnDragResizeEventListener {
		void onDrag(Node node, double x, double y, double h, double w);

		void onResize(Node node, double x, double y, double h, double w);
	}

	private final OnDragResizeEventListener defaultListener = new OnDragResizeEventListener() {
		@Override
		public void onDrag(Node node, double x, double y, double h, double w) {
			/*
			 * // TODO find generic way to get parent width and height of any
			 * node // can perform out of bounds check here if you know your
			 * parent size if (x > width - w ) x = width - w; if (y > height -
			 * h) y = height - h; if (x < 0) x = 0; if (y < 0) y = 0;
			 */
			setNodeSize(node, x, y, h, w);
		}

		@Override
		public void onResize(Node node, double x, double y, double h, double w) {
			/*
			 * // TODO find generic way to get parent width and height of any
			 * node // can perform out of bounds check here if you know your
			 * parent size if (w > width - x) w = width - x; if (h > height - y)
			 * h = height - y; if (x < 0) x = 0; if (y < 0) y = 0;
			 */
			setNodeSize(node, x, y, h, w);
		}

		private void setNodeSize(Node node, double x, double y, double h, double w) {
			node.setLayoutX(x);
			node.setLayoutY(y);
			// TODO find generic way to set width and height of any node
			// here we cant set height and width to node directly.
			// or i just cant find how to do it,
			// so you have to wright resize code anyway for your Nodes...
			// something like this
			if (node instanceof Canvas) {
				((Canvas) node).setWidth(w);
				((Canvas) node).setHeight(h);
			} else if (node instanceof Rectangle) {
				((Rectangle) node).setWidth(w);
				((Rectangle) node).setHeight(h);
			} else if (node instanceof HBox) {
				((HBox) node).setPrefWidth(w);
				((HBox) node).setPrefHeight(h);
			}
		}
	};

	public enum S {
		DEFAULT, DRAG, NW_RESIZE, SW_RESIZE, NE_RESIZE, SE_RESIZE, E_RESIZE, W_RESIZE, N_RESIZE, S_RESIZE;
	}

	private double clickX, clickY, nodeX, nodeY, nodeH, nodeW;

	private S state = S.DEFAULT;

	private Node node;
	private ResizableSprite mySprite;
	private Sprite mySpritePreset;
	private OnDragResizeEventListener listener = defaultListener;
	private InvalidationListener myPresetInvalidationListener;

	private double myMouseX;
	private double myMouseY;

	private static final int MARGIN = 10;
	private static final double MIN_W = 30;
	private static final double MIN_H = 30;

	public DragResizeMod(ResizableSprite sprite, Node node, Sprite spritePreset,
			InvalidationListener invalidationListener, OnDragResizeEventListener listener) {
		this.node = node;
		mySprite = sprite;
		mySpritePreset = spritePreset;
		myPresetInvalidationListener = invalidationListener;
		if (listener != null)
			this.listener = listener;
	}

	public void makeResizable(Node node) {
		makeResizable(node, null);
	}

	public void removePresetListener() {
		if (mySpritePreset != null) {
			mySpritePreset.removeListener(myPresetInvalidationListener);
		}
	}

	public void makeResizable(Node node, OnDragResizeEventListener listener) {

		node.setOnMousePressed((event)->{
			mousePressed(event);
		});
		node.setOnMouseDragged((event)->{
			mouseDragged(event);
		});
		node.setOnMouseMoved((event)->{
			mouseOver(event);
		});
		node.setOnMouseReleased((event) -> {
			mouseReleased(event);
		});
	}
	
	protected void mouseReleased(MouseEvent event) {
		// node.setCursor(Cursor.DEFAULT);
		// state = S.DEFAULT;
		if (state == S.DRAG) {
			mySprite.getSprite().setLocation((new Location(mySprite.getDraggableItem().getLayoutX(),
					mySprite.getDraggableItem().getLayoutY())));
		} 
		else {
			removePresetListener();
			//mySprite.getSprite().setPreset(null);
			mySprite.getSprite().setHeight((int) mySprite.getDraggableItem().getHeight());
			mySprite.getSprite().setWidth((int) mySprite.getDraggableItem().getWidth());
		}
	}

	protected void mouseOver(MouseEvent event) {
		S state = currentMouseState(event);
		Cursor cursor = getCursorForState(state);
		node.setCursor(cursor);
	}

	private S currentMouseState(MouseEvent event) {
		S state = S.DEFAULT;
		boolean left = isLeftResizeZone(event);
		boolean right = isRightResizeZone(event);
		boolean top = isTopResizeZone(event);
		boolean bottom = isBottomResizeZone(event);

		if (left && top)
			state = S.NW_RESIZE;
		else if (left && bottom)
			state = S.SW_RESIZE;
		else if (right && top)
			state = S.NE_RESIZE;
		else if (right && bottom)
			state = S.SE_RESIZE;
		else if (right)
			state = S.E_RESIZE;
		else if (left)
			state = S.W_RESIZE;
		else if (top)
			state = S.N_RESIZE;
		else if (bottom)
			state = S.S_RESIZE;
		else if (isInDragZone(event))
			state = S.DRAG;

		return state;
	}

	private Cursor getCursorForState(S state) {
		switch (state) {
		case NW_RESIZE:
			return Cursor.NW_RESIZE;
		case SW_RESIZE:
			return Cursor.SW_RESIZE;
		case NE_RESIZE:
			return Cursor.NE_RESIZE;
		case SE_RESIZE:
			return Cursor.SE_RESIZE;
		case E_RESIZE:
			return Cursor.E_RESIZE;
		case W_RESIZE:
			return Cursor.W_RESIZE;
		case N_RESIZE:
			return Cursor.N_RESIZE;
		case S_RESIZE:
			return Cursor.S_RESIZE;
		default:
			return Cursor.HAND;
		}
	}

	protected void mouseDragged(MouseEvent event) {

		if (listener != null) {
			double mouseX = parentX(event.getX());
			double mouseY = parentY(event.getY());
			if (state == S.DRAG) {
				double deltaX = event.getSceneX() - myMouseX;
				double deltaY = event.getSceneY() - myMouseY;
				mySprite.getDraggableItem().relocate(mySprite.getDraggableItem().getLayoutX() + deltaX,
						mySprite.getDraggableItem().getLayoutY() + deltaY);
				myMouseX = event.getSceneX();
				myMouseY = event.getSceneY();
			} else if (state != S.DEFAULT) {
				// resizing
				double newX = nodeX;
				double newY = nodeY;
				double newH = nodeH;
				double newW = nodeW;

				// Right Resize
				if (state == S.E_RESIZE || state == S.NE_RESIZE || state == S.SE_RESIZE) {
					newW = mouseX - nodeX;
				}
				// Left Resize
				if (state == S.W_RESIZE || state == S.NW_RESIZE || state == S.SW_RESIZE) {
					newX = mouseX;
					newW = nodeW + nodeX - newX;
				}

				// Bottom Resize
				if (state == S.S_RESIZE || state == S.SE_RESIZE || state == S.SW_RESIZE) {
					newH = mouseY - nodeY;
				}
				// Top Resize
				if (state == S.N_RESIZE || state == S.NW_RESIZE || state == S.NE_RESIZE) {
					newY = mouseY;
					newH = nodeH + nodeY - newY;
				}

				// min valid rect Size Check
				if (newW < MIN_W) {
					if (state == S.W_RESIZE || state == S.NW_RESIZE || state == S.SW_RESIZE)
						newX = newX - MIN_W + newW;
					newW = MIN_W;
				}

				if (newH < MIN_H) {
					if (state == S.N_RESIZE || state == S.NW_RESIZE || state == S.NE_RESIZE)
						newY = newY + newH - MIN_H;
					newH = MIN_H;
				}

				listener.onResize(node, newX, newY, newH, newW);
			}
		}
	}

	protected void mousePressed(MouseEvent event) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				removePresetListener();
				mySprite.getSprite().setPreset(null);
				new SpriteEditWindow(mySprite.getSprite()).openWindow();
			}
		}
		mySprite.getDraggableItem().toFront();
		if (isInResizeZone(event)) {
			setNewInitialEventCoordinates(event);
			state = currentMouseState(event);
		} else if (isInDragZone(event)) {
			setNewInitialEventCoordinates(event);
			state = S.DRAG;
		} else {
			state = S.DEFAULT;
		}
	}

	private void setNewInitialEventCoordinates(MouseEvent event) {
		nodeX = nodeX();
		nodeY = nodeY();
		nodeH = nodeH();
		nodeW = nodeW();
		clickX = event.getX();
		clickY = event.getY();
		myMouseX = event.getSceneX();
		myMouseY = event.getSceneY();
	}

	private boolean isInResizeZone(MouseEvent event) {
		return isLeftResizeZone(event) || isRightResizeZone(event) || isBottomResizeZone(event)
				|| isTopResizeZone(event);
	}

	private boolean isInDragZone(MouseEvent event) {
		double xPos = parentX(event.getX());
		double yPos = parentY(event.getY());
		double nodeX = nodeX() + MARGIN;
		double nodeY = nodeY() + MARGIN;
		double nodeX0 = nodeX() + nodeW() - MARGIN;
		double nodeY0 = nodeY() + nodeH() - MARGIN;

		return (xPos > nodeX && xPos < nodeX0) && (yPos > nodeY && yPos < nodeY0);
	}

	private boolean isLeftResizeZone(MouseEvent event) {
		return intersect(0, event.getX());
	}

	private boolean isRightResizeZone(MouseEvent event) {
		return intersect(nodeW(), event.getX());
	}

	private boolean isTopResizeZone(MouseEvent event) {
		return intersect(0, event.getY());
	}

	private boolean isBottomResizeZone(MouseEvent event) {
		return intersect(nodeH(), event.getY());
	}

	private boolean intersect(double side, double point) {
		return side + MARGIN > point && side - MARGIN < point;
	}

	private double parentX(double localX) {
		return nodeX() + localX;
	}

	private double parentY(double localY) {
		return nodeY() + localY;
	}

	private double nodeX() {
		return node.getBoundsInParent().getMinX();
	}

	private double nodeY() {
		return node.getBoundsInParent().getMinY();
	}

	private double nodeW() {
		return node.getBoundsInParent().getWidth();
	}

	private double nodeH() {
		return node.getBoundsInParent().getHeight();
	}
}