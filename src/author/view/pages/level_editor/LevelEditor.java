package author.view.pages.level_editor;


import author.controller.IAuthorController;
import author.view.pages.level_editor.windows.AbstractLevelEditorWindow;
import author.view.pages.level_editor.windows.LevelWindowFactory;
import author.view.pages.level_editor.windows.level_edit_window.LevelEditWindow;
import game_data.Level;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * This Class serves as a view for the level editor page
 * 
 * @author George Bernard
 * @author Jordan Frazier
 */
class LevelEditor implements ILevelEditorExternal, ILevelEditorInternal{
	private BorderPane myPane;

	private AbstractLevelEditorWindow myLevelWindow;
	private AbstractLevelEditorWindow myEntityWindow;
	private AbstractLevelEditorWindow mySelectionWindow;
	private AbstractLevelEditorWindow myProgressionWindow;
	private IAuthorController authorController;
	private Level level;

	LevelEditor(IAuthorController authorController) {
		this.authorController = authorController;
		myPane = new BorderPane();
		myPane.setCenter(buildLevelWindow());
		myPane.setRight(buildEntityWindow());
		myPane.setLeft(buildLevelSelectionWindow());
		myPane.setBottom(buildLevelProgressionWindow());
	}

	private Pane buildLevelWindow() {
		myLevelWindow = new LevelWindowFactory().create("LevelWindow", this.authorController);
		return myLevelWindow.getWindow();
	}

	private Pane buildEntityWindow() {
		myEntityWindow = new LevelWindowFactory().create("EntityWindow", this.authorController);
		return myEntityWindow.getWindow();
	}

	private Pane buildLevelProgressionWindow() {
		myProgressionWindow = new LevelWindowFactory().create("LevelProgressionWindow", this.authorController);
		return myProgressionWindow.getWindow();
	}

	private Pane buildLevelSelectionWindow() {
		mySelectionWindow = new LevelWindowFactory().create("LevelSelectionWindow", this.authorController);
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
	
	public Level createLevel(){
		LevelEditWindow levelEditWindow = new LevelEditWindow();
		System.out.println("Done with editor");
		return levelEditWindow.getLevel();
	}

	@Override
	public String toString() {
		return "Level Editor";
	}

}
