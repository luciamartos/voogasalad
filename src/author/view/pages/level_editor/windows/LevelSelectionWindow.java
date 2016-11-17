package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
/**
 * This window serves as the container for all levels, where a user will be able to select a level name and
 * the LevelWindow will change to reflect that new level
 * @author Jordan Frazier
 * @see ../LevelEditor
 */
public class LevelSelectionWindow extends AbstractLevelEditorWindow{
	
	public LevelSelectionWindow() {
		super.createWindow();
		createToolBar();
	}

	@Override
	protected void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Selection"));

		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.prefViewportHeightProperty().bind(super.getWindow().heightProperty());

		addChild(tbb.getToolBar());
		addChild(entityScroller);
	}
}
