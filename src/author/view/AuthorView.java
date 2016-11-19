package author.view;

import author.controller.IAuthorController;
import author.view.pages.level_editor.LevelEditor;
import author.view.pages.sprite.SpritesPage;
import author.view.util.TabPaneFacade;
import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import game_data.Level;
import game_data.Location;
import game_data.sprites.Player;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
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
	Pane myPane = new VBox();
	TabPaneFacade myTabPaneFacade;
	IAuthorController authorController;
	
	private LevelEditor myLevelEditor;
	private SpritesPage mySpritesPage = new SpritesPage();

	// TODO move these to properties, as well as button names
	public static final int WIDTH = 800;
	public static final int HEIGHT = 650;
	public static final String BACKGROUND_IMAGE_PATH = "author/images/mymario.jpg";

	public AuthorView(IAuthorController authorController) {
		this.authorController = authorController;
		this.myLevelEditor = new LevelEditor(authorController);
		myScene = new Scene(myPane, WIDTH, HEIGHT, Color.WHITE);
		myPane.getChildren().addAll(buildToolBar(), buildTabPane());
	}

	/**
	 * Returns Toolbar built for primary AuthorScene
	 */
	private Node buildToolBar() {
		ToolBarBuilder toolBarBuilder = new ToolBarBuilder();

		toolBarBuilder.getToolBar().prefWidthProperty().bind(myScene.widthProperty());

		toolBarBuilder.addBurst(new ButtonFactory().createButton("New", e -> {
			// TODO: Still temporary. Need to have user define size, image, etc. and add to gui
			Level createdLevel =new Level(WIDTH, HEIGHT, BACKGROUND_IMAGE_PATH);
			addLevel(createdLevel);
			System.out.println("Create new level");
			//testing
			this.authorController.getModel().getGame().addPreset(new Player(new Location(0, 0, 0), BACKGROUND_IMAGE_PATH, 5));
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
		
		myTabPaneFacade.addTab(mySpritesPage.toString(), mySpritesPage.getRegion());
		myTabPaneFacade.addTab(myLevelEditor.toString(), myLevelEditor.getPane());
		
		return myTabPaneFacade.getTabPane();
	}
	
	private void addLevel(Level createdLevel){
		this.authorController.getModel().getGame().addNewLevel(createdLevel);
	}

	public Scene getScene() {
		return myScene;
	}

}
