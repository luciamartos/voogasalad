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
	BorderPane myPane;

	private AbstractLevelEditorWindow myLevelWindow;
	private AbstractLevelEditorWindow myEntityWindow;
	private AbstractLevelEditorWindow mySelectionWindow;
	private AbstractLevelEditorWindow myProgressionWindow;

	public LevelEditor() {
		myPane = new BorderPane();
		try {
			myPane.setCenter(buildLevelWindow());
			myPane.setRight(buildEntityWindow());
			myPane.setBottom(buildLevelProgressionWindow());
			myPane.setLeft(buildLevelSelectionWindow());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO: Jordan(Vooga): Handle class not found exception;
			e.printStackTrace();
			Platform.exit();
		}
	}

	private Pane buildLevelWindow() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		myLevelWindow = new LevelWindowFactory().create("LevelWindow");
		return myLevelWindow.getWindow();
	}

	private Pane buildEntityWindow() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		myEntityWindow = new LevelWindowFactory().create("EntityWindow");
		return myEntityWindow.getWindow();
	}

	private Pane buildLevelProgressionWindow() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		myProgressionWindow = new LevelWindowFactory().create("LevelProgressionWindow");
		return myProgressionWindow.getWindow();
	}

	private Pane buildLevelSelectionWindow() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		mySelectionWindow =  new LevelWindowFactory().create("LevelSelectionWindow");
		return mySelectionWindow.getWindow();
	}

	public Pane getPane() {
		return myPane;
	}

	@Override
	public String toString() {
		return "Level Editor";
	}

}
