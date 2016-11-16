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
public class LevelProgressionWindow extends AbstractLevelEditorWindow {

	public LevelProgressionWindow() {
		super.createWindow();
		createToolBar();
	}

	@Override
	protected void createToolBar() {		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Progression"));
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.prefViewportWidthProperty().bind(super.getWindow().widthProperty());
		
		addChild(tbb.getToolBar());
		addChild(entityScroller);
	}

}
