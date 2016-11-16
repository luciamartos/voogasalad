package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * This window contains all of the preset sprites. A user will drag and drop sprites from this window
 * onto the LevelWindow
 * @author Jordan Frazier
 * @see LevelWindow
 * @see ../LevelEditor
 */
public class EntityWindow {
	
	private Pane myEntityWindow;
	
	public EntityWindow() {
		createWindow();		
		createToolBar();
	}
	
	private void createWindow() {
		myEntityWindow = new VBox();
	}
	
	public <T extends Node> void addChild(T child) {
		myEntityWindow.getChildren().add(child);
	}

	private void createToolBar() {
		myEntityWindow = new VBox();
		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Entity Selector"));
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.prefViewportHeightProperty().bind(myEntityWindow.heightProperty());
		
		addChild(tbb.getToolBar());
		addChild(entityScroller);
	}
	
	public Pane getWindow() {
		return myEntityWindow;
	}

}
