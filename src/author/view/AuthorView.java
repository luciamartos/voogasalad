package author.view;

import author.view.utility.TabPaneFacade;
import author.view.utility.ToolBarBuilder;
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
	
	// TODO move these to properties, as well as button names
	public static final int WIDTH = 800;
	public static final int HEIGHT = 450;
	
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
		TabPaneFacade tabpaneFacade = new TabPaneFacade();
		tabpaneFacade.getTabPane().prefWidthProperty().bind(myScene.widthProperty());
		tabpaneFacade.getTabPane().prefHeightProperty().bind(myScene.heightProperty());
		tabpaneFacade.getTabPane().setSide(Side.BOTTOM);

		
		// Test Code, TODO change once built page components
		String[] names = new String[]{"Level Editor", "Entity Editor"};
		
		for (int i = 0; i < names.length; i++) {
            tabpaneFacade.addTab(names[i], null);
        }
		
		return tabpaneFacade.getTabPane();
	}
	
	public Scene getScene(){
		return myScene;
	}
	
	
}
