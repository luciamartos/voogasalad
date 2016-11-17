package author.view;

import author.model.game_observables.observable_level.ObservableLevel;
import author.model.game_observables.observable_level.ObservableLevelFactory;
import author.view.pages.level_editor.LevelEditor;
import author.view.pages.sprite.SpritesPage;
import author.view.util.TabPaneFacade;
import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * AuthorView handles the JavaFX GUI.
 * 
 * @author George Bernard
 */
public class AuthorView {

	Scene myScene;
	Pane myPane;
	TabPaneFacade myTabPaneFacade;
	
	private LevelEditor myLevelEditor;
	private SpritesPage mySpritesPage;

	// TODO move these to properties, as well as button names
	public static final int WIDTH = 800;
	public static final int HEIGHT = 650;
	public static final String BACKGROUND_IMAGE_PATH = "dummy/path";

	public AuthorView() {
		myPane = new VBox();
		myScene = new Scene(myPane, WIDTH, HEIGHT, Color.WHITE);
		myLevelEditor = new LevelEditor();
		mySpritesPage = new SpritesPage();
		myPane.getChildren().addAll(buildToolBar(), buildTabPane());

	}

	/**
	 * Returns Toolbar built for primary AuthorScene
	 */
	private Node buildToolBar() {
		ToolBarBuilder toolBarBuilder = new ToolBarBuilder();

		toolBarBuilder.getToolBar().prefWidthProperty().bind(myScene.widthProperty());

		toolBarBuilder.addBurst(new ButtonFactory().createButton("New", e -> {
			ObservableLevel level = new ObservableLevelFactory().create(WIDTH, HEIGHT, BACKGROUND_IMAGE_PATH);
			myLevelEditor.getMySelectionWindow().addChild(new Label("Level 1"));
			// TODO: Jordan(vooga) - New button functionality
			System.out.println("Create new level");
		}).getButton(), new ButtonFactory().createButton("Save", e -> {
			// TODO: Jordan(vooga) - Save button functionality
			System.out.println("Save level");

		}).getButton(), new ButtonFactory().createButton("Load", e -> {
			// TODO: Jordan(vooga) - Load button functionality
			System.out.println("Load level");
		}).getButton());
		
		toolBarBuilder.addFiller();
		toolBarBuilder.addBurst( new ButtonFactory().createButton("Save and Close", e -> {
			// TODO: Jordan(vooga) - Save and close button functionality 
			System.out.println("Save and close level");
		}).getButton());

		return toolBarBuilder.getToolBar();
	}

	/**
	 * Returns TabPane built for primary AuthorScene
	 */
	private Node buildTabPane() {
		myTabPaneFacade = new TabPaneFacade();
		myTabPaneFacade.getTabPane().prefWidthProperty().bind(myScene.widthProperty());
		myTabPaneFacade.getTabPane().prefHeightProperty().bind(myScene.heightProperty());
		myTabPaneFacade.getTabPane().setSide(Side.BOTTOM);

		myTabPaneFacade.addTab(myLevelEditor.toString(), myLevelEditor.getPane());
		myTabPaneFacade.addTab(mySpritesPage.toString(), mySpritesPage.getRegion());

		return myTabPaneFacade.getTabPane();
	}

	public Scene getScene() {
		return myScene;
	}

}
