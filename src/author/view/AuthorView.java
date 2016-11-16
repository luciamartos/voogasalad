package author.view;

import author.view.pages.level_editor.LevelEditor;
import author.view.pages.sprite.SpritesPage;
import author.view.util.TabPaneFacade;
import author.view.util.ToolBarBuilder;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	// TODO move these to properties, as well as button names
	public static final int WIDTH = 800;
	public static final int HEIGHT = 650;
	
	public AuthorView(){
		myPane = new VBox();
		myScene = new Scene(myPane, WIDTH, HEIGHT, Color.WHITE);
		myPane.getChildren().addAll(buildToolBar(), buildTabPane());
		
	}

	/**
	 * Returns Toolbar built for primary AuthorScene
	 */
	private Node buildToolBar(){
		ToolBarBuilder toolBarBuilder = new ToolBarBuilder();
		
		toolBarBuilder.getToolBar().prefWidthProperty().bind(myScene.widthProperty());
		toolBarBuilder.addBurst( new Button("New"), new Button("Save"), new Button("Load"));
		toolBarBuilder.addFiller();
		toolBarBuilder.addBurst(new Button("Save and Close"));
		
		return toolBarBuilder.getToolBar();
	}

	/**
	 * Returns TabPane built for primary AuthorScene
	 */
	private Node buildTabPane(){
		myTabPaneFacade = new TabPaneFacade();
		myTabPaneFacade.getTabPane().prefWidthProperty().bind(myScene.widthProperty());
		myTabPaneFacade.getTabPane().prefHeightProperty().bind(myScene.heightProperty());
		myTabPaneFacade.getTabPane().setSide(Side.BOTTOM);

		
		LevelEditor levelEditor = new LevelEditor();
		SpritesPage spritesPage = new SpritesPage();
		
		myTabPaneFacade.addTab(levelEditor.toString(), levelEditor.getPane());
		myTabPaneFacade.addTab(spritesPage.toString(), spritesPage.getRegion());

		
		return myTabPaneFacade.getTabPane();
	}
	
	public Scene getScene(){
		return myScene;
	}
	
	
}
