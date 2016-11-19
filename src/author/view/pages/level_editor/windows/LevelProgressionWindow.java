package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
/**
 * This window will allow a user to see the progression of their levels. 
 * (@george so this window will need to automatically update when a user changes the 'end level' condition
 * on a level?)
 * @author Jordan Frazier
 * @see ../LevelEditor
 *
 */
public class LevelProgressionWindow extends AbstractLevelEditorWindow {

	private ScrollPane progressionScroller;
	private HBox container;
	
	public LevelProgressionWindow() {
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
		tbb.addBurst(new Label("Level Progression"));
		
		container = new HBox();
		progressionScroller = new ScrollPane();
		progressionScroller.setFitToHeight(true);
		progressionScroller.setFitToWidth(true);
		
		progressionScroller.setVbarPolicy(ScrollBarPolicy.NEVER);
		progressionScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		progressionScroller.prefHeightProperty().bind(super.getWindow().heightProperty());
		progressionScroller.prefWidthProperty().bind(super.getWindow().widthProperty());

//		container.prefHeightProperty().bind(progressionScroller.prefViewportHeightProperty());
//		container.prefWidthProperty().bind(progressionScroller.prefViewportHeightProperty());
		
		progressionScroller.setContent(container);
		super.getWindow().setMaxHeight(100);
		super.getWindow().setMinHeight(100);
		
		super.getWindow().getChildren().add(tbb.getToolBar());
		super.getWindow().getChildren().add(progressionScroller);
	}

}
