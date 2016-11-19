package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.TilePane;
/**
 * This window contains all of the preset sprites. A user will drag and drop sprites from this window
 * onto the LevelWindow
 * @author Jordan Frazier
 * @see LevelWindow
 * @see ../LevelEditor
 */
public class EntityWindow extends AbstractLevelEditorWindow {
		
	private ScrollPane entityScroller;
	private TilePane container;
	
	public EntityWindow() {
		super.createWindow();		
		createToolBar();
	}
	
	@Override
	public <T extends Node> void addChildren(T... child) {
		for (T node : child) {
			container.getChildren().add(node);
		}
	}

	@Override
	protected void createToolBar() {		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Entity Selector"));
		
		container = new TilePane();
		entityScroller = new ScrollPane();
		entityScroller.setFitToHeight(true);
		entityScroller.setFitToWidth(true);
		
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.prefHeightProperty().bind(super.getWindow().heightProperty());
		entityScroller.prefWidthProperty().bind(super.getWindow().widthProperty());

//		container.prefWidthProperty().bind(super.getWindow().widthProperty());
//		container.prefHeightProperty().bind(super.getWindow().heightProperty());

		entityScroller.setContent(container);
		
		super.getWindow().getChildren().add(tbb.getToolBar());
		super.getWindow().getChildren().add(entityScroller);
	}
}
