package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LevelSelectionWindow {
	
	private Pane mySelectionWindow;

	public LevelSelectionWindow() {
		createWindow();
		createToolBar();
	}

	private void createWindow() {
		mySelectionWindow = new VBox();
	}

	public <T extends Node> void addChild(T child) {
		mySelectionWindow.getChildren().add(child);
	}

	private void createToolBar() {

		mySelectionWindow = new VBox();

		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Selection"));

		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.prefViewportHeightProperty().bind(mySelectionWindow.heightProperty());

		addChild(tbb.getToolBar());
		addChild(entityScroller);
	}

	public Pane getWindow() {
		return mySelectionWindow;
	}

}
