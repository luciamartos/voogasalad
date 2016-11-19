package author.view.pages.level_editor.windows;

import author.controller.IAuthorController;
import game_data.Level;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * The abstract class that windows in the level editor will extend
 * 
 * @author Jordan Frazier, Cleveland Thompson
 *
 */
public abstract class AbstractLevelEditorWindow {

	private Pane myWindow;
	private IAuthorController authorController;
	private Level level;
	
	public AbstractLevelEditorWindow(IAuthorController authorController, Level aLevel){
		this.level = aLevel;
		this.authorController = authorController;
		createWindow();
		createToolBar();
		initListener(this.authorController, this.level);
	}

	public <T extends Node> void addChildren(T... child) {
		for(T node : child) {
			myWindow.getChildren().add(node);
		}
	}

	public Pane getWindow() {
		return myWindow;
	}
	
	protected Pane createWindow() {
		myWindow = new VBox();
		return myWindow;
	}
	
	protected abstract void initListener(IAuthorController authorController, Level aLevel);
	
	protected abstract void createToolBar();
}
