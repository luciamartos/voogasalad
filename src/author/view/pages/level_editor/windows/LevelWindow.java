package author.view.pages.level_editor.windows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import author.controller.IAuthorController;
import author.model.game_observables.draggable_sprite.ConcreteMovableSprite;
import author.model.game_observables.draggable_sprite.DraggableSprite;
import author.view.util.FileLoader;
import author.view.util.FileLoader.FileType;
import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import game_data.Level;
import game_data.Sprite;
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
	private List<DraggableSprite> spriteList = new ArrayList<>();

	public LevelWindow(IAuthorController authorController, Level aLevel) {
		super(authorController, aLevel);
		myController = authorController;
		createLevelScroller();
	}

	@Override
	public <T extends Node> void addChildren(T... child) {
		for (T node : child) {
			container.getChildren().add(node);
		}
	}

	@Override
	protected void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new ButtonFactory().createButton("Set Background", e -> {
			setBackgroundImage();
			System.out.println("Change background here");
		}).getButton(), new ButtonFactory().createButton("Set Theme", e -> {
			// TODO: Jordan - Add functionality to changing theme, what the
			// fucks a theme
			System.out.println("Change theme here");
		}).getButton());

		super.getWindow().getChildren().add(tbb.getToolBar());
	}

	private void createLevelScroller() {
		myLevelScroller = new ScrollPane();
		myContainer = new Pane();
		myContainer.setOnDragEntered(e -> {
			System.out.println("Drag entered level editor pane");
		});

		acceptDraggableSprites();
		myContainer.prefWidthProperty().bind(myLevelScroller.widthProperty());
		myContainer.prefHeightProperty().bind(myLevelScroller.heightProperty());

		myLevelScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		myLevelScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		myLevelScroller.prefViewportHeightProperty().bind(super.getWindow().heightProperty());
		myLevelScroller.setContent(myContainer);

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
				
				DraggableSprite newSprite = new ConcreteMovableSprite(sprite);

				ImageView image = newSprite.getImageView();
				image.setFitHeight(40);
				image.setFitWidth(40);
				if (image != null) {
					myContainer.getChildren().add(image);
					image.setLayoutX(event.getX() - 20);
					image.setLayoutY(event.getY() - 20);
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

	private Sprite findSprite(String nodeId) {
		for (Sprite s : myController.getModel().getGame().getPresets()) {
			if (nodeId.equals(s.getId())) {
				return s;
			}
		} 
		return null;
	}

	private void setBackgroundImage() {
		File file = new FileLoader(FileType.GIF, FileType.JPEG, FileType.PNG, FileType.JPG).loadImage();

		System.out.println(file.toURI().toString());

		Image image = new Image(file.toURI().toString());
		BackgroundImage backIm = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(image.getWidth(), image.getHeight(), false, false, false, false));
		
		container.setBackground(new Background(backIm));
		container.setMinSize(image.getWidth(), image.getHeight());
	}
	
	@Override
	public void SetLevel(Level aLevel){
		super.SetLevel(aLevel);
		updatePane();
		getLevel().addListener((level) -> {
			updatePane();
			System.out.println("Updated");
		});
		
	}
	
	private void updatePane(){
		this.container.getChildren().clear();
		getLevel().getMySpriteList().forEach((sprite) -> {
			DraggableSprite draggableSprite = new ConcreteDraggableSprite(sprite);
			this.container.getChildren().add(draggableSprite.getImageView());
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