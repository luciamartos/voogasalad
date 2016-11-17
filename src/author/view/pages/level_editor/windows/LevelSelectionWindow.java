package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * This window serves as the container for all levels, where a user will be able to select a level name and
 * the LevelWindow will change to reflect that new level
 * @author Jordan Frazier
 * @see ../LevelEditor
 */
public class LevelSelectionWindow extends AbstractLevelEditorWindow{
	
	private ScrollPane entityScroller;
	private Pane container;
	
	public LevelSelectionWindow() {
		super.createWindow();
		createToolBar();
	}
	
	@Override
	public <T extends Node> void addChild(T child) {
		container.getChildren().add(child);
	}

	@Override
	protected void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Selection"));
		
		container = new VBox();
		entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.prefViewportHeightProperty().bind(super.getWindow().heightProperty());
		entityScroller.setContent(container);

		super.getWindow().getChildren().add(tbb.getToolBar());
		super.getWindow().getChildren().add(entityScroller);
	}
}
