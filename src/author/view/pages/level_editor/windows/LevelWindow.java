package author.view.pages.level_editor.windows;

import java.io.File;

import author.controller.IAuthorController;
import author.model.game_observables.draggable_sprite.ConcreteMovableSprite;
import author.model.game_observables.draggable_sprite.DraggableSprite;
import author.view.util.FileLoader;
import author.view.util.FileLoader.FileType;
import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import game_data.Level;
import game_data.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 * This window is the actual level editor, where sprites will be placed from the
 * EntityWindow
 * 
 * @author Jordan Frazier
 * @see EntityWindow
 * @see ../LevelEditor
 */
public class LevelWindow extends AbstractLevelEditorWindow {

	private ScrollPane myLevelScroller;
	private Pane myContainer;
	private IAuthorController myController;
	
	private IntegerProperty horizontalPanes = new SimpleIntegerProperty();
	private IntegerProperty verticalPanes = new SimpleIntegerProperty();
	private static final int INITIAL_PANES = 2;
	
	public LevelWindow(IAuthorController authorController) {
		super(authorController);
		myController = authorController;
		horizontalPanes.set(INITIAL_PANES);
		verticalPanes.set(INITIAL_PANES);
		createLevelScroller();
	}

	@Override
	public <T extends Node> void addChildren(T... child) {
		for (T node : child) {
			myContainer.getChildren().add(node);
		}
	}

	@Override
	protected void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new ButtonFactory().createButton("Set Background", e -> {
			setBackgroundImage();
		}).getButton(), new ButtonFactory().createButton("Set Theme", e -> {
			// TODO: Jordan(vooga) - Add functionality to changing theme
			System.out.println("Change theme here");
		}).getButton(), new ButtonFactory().createButton("Extend Right", e -> {
			extendPaneRight();
		}).getButton(), new ButtonFactory().createButton("Extend Down", e -> {
			extendPaneDown();
		}).getButton());

		super.getWindow().getChildren().add(tbb.getToolBar());
	}

	private void extendPaneDown() {
		myContainer.setPrefHeight(myLevelScroller.getPrefViewportHeight() * verticalPanes.get());
		verticalPanes.set(verticalPanes.get() + 1);
	}

	private void extendPaneRight() {
		myContainer.setPrefWidth(myLevelScroller.getPrefViewportWidth() * horizontalPanes.get());
		horizontalPanes.set(horizontalPanes.get() + 1);
	}

	private void createLevelScroller() {
		myLevelScroller = new ScrollPane();
		myContainer = new Pane();
		myContainer.setOnDragEntered(e -> {
			System.out.println("Drag entered level editor pane");
		});

		myLevelScroller.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myLevelScroller.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

		// Lol these are staying hard coded, the user gon have to pay extra for features like changing window size
		myLevelScroller.setPrefViewportHeight(400);
		myLevelScroller.setPrefViewportWidth(500);
		
		myContainer.setPrefHeight(myLevelScroller.getPrefViewportHeight());
		myContainer.setPrefWidth(myLevelScroller.getPrefViewportWidth());
		
		myLevelScroller.setContent(myContainer);
		acceptDraggableSprites();

		super.getWindow().getChildren().add(myLevelScroller);
	}

	private void acceptDraggableSprites() {

		myContainer.setOnDragDropped((DragEvent event) -> {
			System.out.println("DRAG DROPPED IN PANE");
			Dragboard db = event.getDragboard();
			boolean success = false;
			if (db.hasString()) {
				String nodeId = db.getString();
				Sprite sprite = findSprite(nodeId);

				DraggableSprite newSprite;
				try {
					newSprite = new ConcreteMovableSprite(sprite);
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					throw new NullPointerException();
				}

				ImageView image = newSprite.getImageView();
				image.setFitHeight(sprite.getMyHeight());
				image.setFitWidth(sprite.getMyWidth());
				if (image != null) {
					myContainer.getChildren().add(image);
					image.setLayoutX(event.getX());
					image.setLayoutY(event.getY());
					newSprite.getSprite().getMyLocation().setLocation(image.getLayoutX(), image.getLayoutY());
					success = true;
				}
			}
			event.setDropCompleted(success);
			event.consume();
		});

		myContainer.setOnDragOver((DragEvent event) -> {
			if (event.getDragboard().hasString()) {
				event.acceptTransferModes(TransferMode.MOVE);
			}
			event.consume();
		});
	}

	private void setBackgroundImage() {
		File file = new FileLoader(FileType.GIF, FileType.JPEG, FileType.PNG, FileType.JPG).loadImage();

		System.out.println(file.toURI().toString());

		Image image = new Image(file.toURI().toString());
		BackgroundImage backIm = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(image.getWidth(), image.getHeight(), false, false, false, false));

		myContainer.setBackground(new Background(backIm));
		myContainer.setMinSize(image.getWidth(), image.getHeight());
	}

	/**
	 * Loops through all presets to find the correct sprite being dragged. 
	 * TODO: Update this to more efficient method
	 * @param nodeId
	 * @return
	 */
	private Sprite findSprite(String nodeId) {
		for (Sprite s : myController.getModel().getGame().getPresets()) {
			if (nodeId.equals(s.getId())) {
				return s;
			}
		}
		return null;
	}

	@Override
	public void setLevel(Level aLevel) {
		super.setLevel(aLevel);
		updatePane();
		getLevel().addListener((level) -> {
			updatePane();
			System.out.println("Updated");
		});

	}

	private void updatePane() {
		myContainer.getChildren().clear();
		getLevel().getMySpriteList().forEach((sprite) -> {
			DraggableSprite draggableSprite = new ConcreteMovableSprite(sprite);
			myContainer.getChildren().add(draggableSprite.getImageView());
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see author.view.pages.level_editor.windows.AbstractLevelEditorWindow#
	 * initListener(author.controller.IAuthorController, game_data.Level)
	 */
	@Override
	protected void initListener(IAuthorController authorController) {

	}

}
