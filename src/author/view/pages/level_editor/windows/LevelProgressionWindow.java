package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * This window will allow a user to see the progression of their levels. 
 * (@george so this window will need to automatically update when a user changes the 'end level' condition
 * on a level?)
 * @author Jordan Frazier
 * @see ../LevelEditor
 *
 */
public class LevelProgressionWindow {

	private Pane myProgressionWindow;

	public LevelProgressionWindow() {
		createWindow();
		createToolBar();
	}

	private void createWindow() {
		myProgressionWindow = new VBox();
	}

	public <T extends Node> void addChild(T child) {
		myProgressionWindow.getChildren().add(child);
	}

	private void createToolBar() {
		myProgressionWindow = new VBox();
		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Progression"));
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.prefViewportWidthProperty().bind(myProgressionWindow.widthProperty());
		
		addChild(tbb.getToolBar());
		addChild(entityScroller);
	}

	public Pane getWindow() {
		return myProgressionWindow;
	}

}
