package author.view;

import author.controller.IAuthorController;
import author.view.pages.level_editor.LevelEditor;
import author.view.pages.menu.MenuFactory;
import author.view.pages.sprite.SpritesPage;
import author.view.util.TabPaneFacade;
import game_data.Level;
import game_data.Location;
import game_data.sprites.Player;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * AuthorView handles the JavaFX GUI.
 * 
 * @author George Bernard, Cleveland Thompson
 */
public class AuthorView {

	Scene myScene;
	Pane myPane = new VBox();
	TabPaneFacade myTabPaneFacade;
	IAuthorController authorController;

	private LevelEditor myLevelEditor;
	private SpritesPage mySpritesPage;

	// TODO move these to properties, as well as button names
	public static final int WIDTH = 800;
	public static final int HEIGHT = 650;
	public static final String SPRITE_IMAGE_PATH = "author/images/mymario.jpg";
	public static final String BACKGROUND_IMAGE_PATH = "author/images/mario.jpg";

	public AuthorView(IAuthorController authorController) {
		this.authorController = authorController;
		this.mySpritesPage = new SpritesPage(authorController);
		this.myLevelEditor = new LevelEditor(authorController);
		myScene = new Scene(myPane, WIDTH, HEIGHT, Color.WHITE);
		myPane.getChildren().addAll(buildToolBar(), buildTabPane());
	}

	/**
	 * Returns Toolbar built for primary AuthorScene
	 */
	private Node buildToolBar() {

		MenuBar menuBar = new MenuBar();
		Menu menuNew = new Menu("New");
		Menu menuSave = new Menu("Save");
		Menu menuLoad = new Menu("Load");
		menuBar.getMenus().addAll(menuNew, menuSave, menuLoad);

		menuNew.getItems().addAll(new MenuFactory().createItem("New Game", e -> {
			// TODO: Jordan(vooga) - create new game
		}).getItem(), new MenuFactory().createItem("New Level", e -> {
			Level createdLevel =new Level("Level 1", WIDTH, HEIGHT, BACKGROUND_IMAGE_PATH);
			addLevel(createdLevel);
			System.out.println("Create new level");
			//testing
		}).getItem());

		menuSave.getItems().add(new MenuFactory().createItem(("Save Game"), e -> {
			// Save game
		}).getItem());
		
		menuLoad.getItems().add(new MenuFactory().createItem("Load Game",  e -> {
			// Load game
		}).getItem());

		return menuBar;
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
		this.myLevelEditor.getMyLevelWindow().setLevel(createdLevel);
	}

	public Scene getScene() {
		return myScene;
	}

}
