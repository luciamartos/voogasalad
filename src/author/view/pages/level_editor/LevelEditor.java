package author.view.pages.level_editor;

import author.controller.IAuthorController;
import author.view.pages.level_editor.windows.AbstractLevelEditorWindow;
import author.view.pages.level_editor.windows.LevelWindowFactory;
import game_data.Level;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * This Class serves as a view for the level editor page
 * 
 * @author George Bernard
 * @author Jordan Frazier
 */
public class LevelEditor {
	BorderPane myPane;

	private AbstractLevelEditorWindow myLevelWindow;
	private AbstractLevelEditorWindow myEntityWindow;
	private AbstractLevelEditorWindow mySelectionWindow;
	private AbstractLevelEditorWindow myProgressionWindow;
	private IAuthorController authorController;
	private Level level;

	public LevelEditor(IAuthorController authorController, Level aLevel) {
		this.authorController = authorController;
		this.level = aLevel;
		myPane = new BorderPane();
		myPane.setCenter(buildLevelWindow());
		myPane.setRight(buildEntityWindow());
		myPane.setBottom(buildLevelProgressionWindow());
		myPane.setLeft(buildLevelSelectionWindow());
	}

	private Pane buildLevelWindow() {
		myLevelWindow = new LevelWindowFactory().create("LevelWindow", this.authorController, this.level);
		return myLevelWindow.getWindow();
	}

	private Pane buildEntityWindow() {
		myEntityWindow = new LevelWindowFactory().create("EntityWindow", this.authorController, this.level);
		return myEntityWindow.getWindow();
	}

	private Pane buildLevelProgressionWindow() {
		myProgressionWindow = new LevelWindowFactory().create("LevelProgressionWindow", this.authorController, this.level);
		return myProgressionWindow.getWindow();
	}

	private Pane buildLevelSelectionWindow() {
		mySelectionWindow = new LevelWindowFactory().create("LevelSelectionWindow", this.authorController, this.level);
		return mySelectionWindow.getWindow();
	}

	public Pane getPane() {
		return myPane;
	}

	public AbstractLevelEditorWindow getMyLevelWindow() {
		return myLevelWindow;
	}

	public AbstractLevelEditorWindow getMyEntityWindow() {
		return myEntityWindow;
	}

	public AbstractLevelEditorWindow getMySelectionWindow() {
		return mySelectionWindow;
	}

	public AbstractLevelEditorWindow getMyProgressionWindow() {
		return myProgressionWindow;
	}

	@Override
	public String toString() {
		return "Level Editor";
	}

}
