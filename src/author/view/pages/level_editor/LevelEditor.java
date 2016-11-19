package author.view.pages.level_editor;

import author.view.pages.level_editor.windows.AbstractLevelEditorWindow;
import author.view.pages.level_editor.windows.EntityWindow;
import author.view.pages.level_editor.windows.LevelProgressionWindow;
import author.view.pages.level_editor.windows.LevelSelectionWindow;
import author.view.pages.level_editor.windows.LevelWindow;
import author.view.pages.level_editor.windows.LevelWindowFactory;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * This Class serves as a view for the level editor page
 * 
 * @author George Bernard
 * @author Jordan Frazier
 */
public class LevelEditor {
	private BorderPane myPane;

	private AbstractLevelEditorWindow myLevelWindow;
	private AbstractLevelEditorWindow myEntityWindow;
	private AbstractLevelEditorWindow mySelectionWindow;
	private AbstractLevelEditorWindow myProgressionWindow;

	public LevelEditor() {
		myPane = new BorderPane();
		myPane.setCenter(buildLevelWindow());
		myPane.setRight(buildEntityWindow());
		myPane.setLeft(buildLevelSelectionWindow());
		myPane.setBottom(buildLevelProgressionWindow());
	}

	private Pane buildLevelWindow() {
		myLevelWindow = new LevelWindowFactory().create("LevelWindow");
		return myLevelWindow.getWindow();
	}

	private Pane buildEntityWindow() {
		myEntityWindow = new LevelWindowFactory().create("EntityWindow");
		return myEntityWindow.getWindow();
	}

	private Pane buildLevelProgressionWindow() {
		myProgressionWindow = new LevelWindowFactory().create("LevelProgressionWindow");
		return myProgressionWindow.getWindow();
	}

	private Pane buildLevelSelectionWindow() {
		mySelectionWindow = new LevelWindowFactory().create("LevelSelectionWindow");
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
