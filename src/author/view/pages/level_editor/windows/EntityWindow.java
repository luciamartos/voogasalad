package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
/**
 * This window contains all of the preset sprites. A user will drag and drop sprites from this window
 * onto the LevelWindow
 * @author Jordan Frazier
 * @see LevelWindow
 * @see ../LevelEditor
 */
public class EntityWindow extends AbstractLevelEditorWindow {
		
	public EntityWindow() {
		super.createWindow();		
		createToolBar();
	}

	@Override
	protected void createToolBar() {		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Entity Selector"));
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.prefViewportHeightProperty().bind(super.getWindow().heightProperty());
		
		addChild(tbb.getToolBar());
		addChild(entityScroller);
	}
}
