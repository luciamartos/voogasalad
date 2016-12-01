package author.view.pages.level_editor.windows;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import author.controller.IAuthorController;
import author.model.game_observables.draggable_sprite.ConcreteMovableSprite;
import author.model.game_observables.draggable_sprite.DraggableSprite;
import author.view.pages.level_editor.windows.level_window.LevelWindowPaneFactory;
import author.view.pages.level_editor.windows.level_window.LevelWindowScrollerFactory;
import author.view.util.authoring_buttons.ButtonFactory;
import author.view.util.facades.ToolBarBuilder;
import author.view.util.file_helpers.FileLoader;
import author.view.util.file_helpers.FileLoader.FileType;
import game_data.Level;
import game_data.Sprite;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
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
 * @author Jordan Frazier, Cleveland Thompson
 * @see EntityWindow
 * @see ../LevelEditor
 */
public class LevelWindow extends AbstractLevelEditorWindow{

	private ScrollPane levelScroller;
	private Pane levelPane;
	
	private IntegerProperty horizontalPanes = new SimpleIntegerProperty(1);
	private IntegerProperty verticalPanes = new SimpleIntegerProperty(1);
	private Map<Level, Pane> levelPanes = new HashMap<>();
	
	public LevelWindow(IAuthorController authorController) {
		super(authorController);
		createScroller();
	}
	
	private void createScroller(){
		this.levelScroller = new LevelWindowScrollerFactory((ILevelEditorWindowInternal) this).create();
		this.levelScroller.setContent(this.levelPane);
		this.getWindow().getChildren().add(this.levelScroller);
<<<<<<< HEAD
		//this.levelScroller.prefWidthProperty().bind(this.getWindow().widthProperty());
		//this.levelScroller.prefHeightProperty().bind(this.getWindow().heightProperty());
=======
>>>>>>> ec000dd4adefeabc8ccbbfa2187342210a7ec767
		this.levelScroller.prefViewportWidthProperty().bind(this.getWindow().widthProperty());
		this.levelScroller.prefViewportHeightProperty().bind(this.getWindow().heightProperty());
		System.out.println("WIN: " + this.getWindow().getWidth());
		
		System.out.println("Scroller Height and Width: " + this.levelScroller.getWidth() + "  " + this.levelScroller.getHeight());
	}
	
	

	@Override
	protected void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new ButtonFactory().createButton("Set Background", e -> {
			newBackgroundImage();
		}).getButton(), new ButtonFactory().createButton("Set Theme", e -> {
			//TODO: Set Theme Here
		}).getButton(), new ButtonFactory().createButton("Extend Right", e -> {
			horizontalPanes.set(horizontalPanes.get() + 1);
		}).getButton(), new ButtonFactory().createButton("Extend Down", e -> {
			verticalPanes.set(verticalPanes.get() + 1);
		}).getButton());

		super.getWindow().getChildren().add(tbb.getToolBar());
	}

	private void newBackgroundImage() {
		File file = new FileLoader(FileType.GIF, FileType.JPEG, FileType.PNG, FileType.JPG).loadImage();

		if (file != null)
			this.getController().getModel().getGame().getCurrentLevel()
					.setBackgroundImageFilePath(file.toURI().toString());
	}

	private void setBackgroundImage(String filePath) {
		System.out.println("Set BackGround Image");
		Image image = new Image(filePath);
		BackgroundImage backIm = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(100, 100, true, true, true, true));
		this.levelPane.setBackground(new Background(backIm));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see author.view.pages.level_editor.windows.AbstractLevelEditorWindow#
	 * initListener(author.controller.IAuthorController, game_data.Level)
	 */
	@Override
	protected void initListener() {
		
		getController().getModel().getGame().addListener((game) -> {
			Level currentLevel = getController().getModel().getGame().getCurrentLevel();
			if (currentLevel != null)
				updateLevel(currentLevel);
		});
	}

	private void updateLevel(Level aLevel) {
		if (!this.levelPanes.containsKey(aLevel)){
			
			Pane newLevelPane = new LevelWindowPaneFactory((ILevelEditorWindowInternal) this, this.getController()).create(); 
			
			this.levelPane = newLevelPane;
			this.levelPanes.put(aLevel, this.levelPane);
			this.levelScroller.setContent(this.levelPane);
<<<<<<< HEAD
=======
			
>>>>>>> ec000dd4adefeabc8ccbbfa2187342210a7ec767
			this.getWindow().widthProperty().addListener((listener) -> updateLevelSize(newLevelPane, aLevel));
			this.levelScroller.boundsInLocalProperty().addListener((listener) -> updateLevelSize(newLevelPane, aLevel));
			this.horizontalPanes.addListener((listener) -> updateLevelSize(newLevelPane, aLevel));
			this.verticalPanes.addListener((listener) -> updateLevelSize(newLevelPane, aLevel));
			
			aLevel.addListener((level) -> {
				updatePane(aLevel);
			});
		}
		updateLevelSize(this.levelPanes.get(aLevel), aLevel);
		System.out.println(aLevel.getHeight());
		System.out.println(aLevel.getWidth());
		updatePane(aLevel);
		
	}
	
	private void updateLevelSize(Pane aLevelPane, Level aLevel){
<<<<<<< HEAD
		System.out.println("Win2: " + this.getWindow().getWidth());
		aLevel.setWidth((int) this.levelScroller.getViewportBounds().getWidth() * this.horizontalPanes.get());
		aLevel.setHeight((int) this.levelScroller.getViewportBounds().getHeight() * this.verticalPanes.get());
=======
		if (this.levelScroller.getWidth() != 0.0){
			aLevel.setWidth((int) this.levelScroller.getViewportBounds().getWidth() * this.horizontalPanes.get());
			aLevel.setHeight((int) this.levelScroller.getViewportBounds().getHeight() * this.verticalPanes.get());
		}
>>>>>>> ec000dd4adefeabc8ccbbfa2187342210a7ec767
		updatePaneSize(aLevelPane, aLevel);
	}
	
	private void updatePaneSize(Pane levelPane, Level aLevel){
		levelPane.setPrefWidth(aLevel.getWidth());
		levelPane.setPrefHeight(aLevel.getHeight());
	}

	private void updatePane(Level aLevel) {
		this.levelPane = this.levelPanes.get(aLevel);
		System.out.println("update pane");
		
		Set<Sprite> levelSprites = this.getNewSprites(this.getDraggableSprites(), aLevel.getMySpriteList());
		
		levelSprites.forEach((sprite) -> {
			initPresetListener(sprite, sprite.getPreset());
			DraggableSprite draggableSprite = new ConcreteMovableSprite(sprite);
			this.addDraggableSprite(draggableSprite);
			styleSpriteImageView(sprite, draggableSprite);
			this.levelPane.getChildren().add(draggableSprite.getImageView());
		});
		
		if (aLevel.getBackgroundImageFilePath() != null)
			setBackgroundImage(aLevel.getBackgroundImageFilePath());	
		
	}
	
	private void initPresetListener(Sprite instanceSprite, Sprite spritePreset){
		InvalidationListener invalidationListener = (sprite) -> {
			instanceSprite.setMyImagePath(spritePreset.getMyImagePath());
			instanceSprite.setMyWidth(spritePreset.getMyWidth());
			instanceSprite.setMyHeight(spritePreset.getMyHeight());
		};
		spritePreset.addListener(invalidationListener);
	}

	private void styleSpriteImageView(Sprite sprite, DraggableSprite draggableSprite) {
		draggableSprite.getImageView().setLayoutX(sprite.getMyLocation().getXLocation());
		draggableSprite.getImageView().setLayoutY(sprite.getMyLocation().getYLocation());
		draggableSprite.getImageView().setFitWidth(sprite.getMyWidth());
		draggableSprite.getImageView().setFitHeight(sprite.getMyHeight());
	}

}
