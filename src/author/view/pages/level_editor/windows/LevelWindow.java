package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * This window is the actual level editor, where sprites will be placed from the EntityWindow
 * @author Jordan Frazier
 * @see EntityWindow
 * @see ../LevelEditor
 */
public class LevelWindow {
	
	private Pane myLevelWindow;
	
	public LevelWindow() {
		createWindow();		
		createToolBar();
	}
	
	private void createWindow() {
		myLevelWindow = new VBox();
	}
	
	public <T extends Node> void addChild(T child) {
		myLevelWindow.getChildren().add(child);
	}

	private void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new ButtonFactory().createButton("Set Background", e -> {
			// TODO: Jordan - Add functionality to changing background
			System.out.println("Change background here");
		}).getButton(), new ButtonFactory().createButton("Set Theme", e -> {
			// TODO: Jordan - Add functionality to changing theme
			System.out.println("Change theme here");
		}).getButton());
		
		addChild(tbb.getToolBar());
	}
	
	public Pane getWindow() {
		return myLevelWindow;
	}
}
