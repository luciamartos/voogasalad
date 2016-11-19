package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;

/**
 * This window serves as the container for all levels, where a user will be able
 * to select a level name and the LevelWindow will change to reflect that new
 * level
 * 
 * @author Jordan Frazier
 * @see ../LevelEditor
 */
public class LevelSelectionWindow extends AbstractLevelEditorWindow {

	private ScrollPane levelScroller;
	private VBox container;

	public LevelSelectionWindow() {
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
		tbb.addBurst(new Label("Level Selection"));
		
		container = new VBox();
		levelScroller = new ScrollPane();
		
		levelScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		levelScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		levelScroller.prefViewportHeightProperty().bind(super.getWindow().heightProperty());
		levelScroller.prefViewportWidthProperty().bind(super.getWindow().widthProperty());
		
		container.prefHeightProperty().bind(super.getWindow().heightProperty());
		container.prefWidthProperty().bind(super.getWindow().widthProperty());
//		container.setPrefWidth(Double.MAX_VALUE);
//		container.setPrefHeight(Double.MAX_VALUE);
		
		levelScroller.setContent(container);

		super.getWindow().getChildren().add(tbb.getToolBar());
		super.getWindow().getChildren().add(levelScroller);
	}
}
