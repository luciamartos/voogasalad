package author.view.pages.level_editor;

import author.view.pages.level_editor.windows.EntityWindow;
import author.view.pages.level_editor.windows.LevelProgressionWindow;
import author.view.pages.level_editor.windows.LevelSelectionWindow;
import author.view.pages.level_editor.windows.LevelWindow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * This Class serves as a view for the level editor page
 * 
 * @author George Bernard
 */
public class LevelEditor {
	BorderPane myPane;
	
	private LevelWindow myLevelWindow;
	private EntityWindow myEntityWindow;
	private LevelSelectionWindow mySelectionWindow;
	private LevelProgressionWindow myProgressionWindow;
	
	public LevelEditor(){
		myPane = new BorderPane();
		myPane.setCenter(buildLevelWindow());
		myPane.setRight(buildEntityWindow());
		myPane.setBottom(buildLevelProgressionWindow());
		myPane.setLeft(buildLevelSelectionWindow());
	}
	
	private Pane buildLevelWindow(){
		myLevelWindow = new LevelWindow();
		return myLevelWindow.getWindow();
	}
	
	private Pane buildEntityWindow(){
		myEntityWindow = new EntityWindow();
		return myEntityWindow.getWindow();
	}
	
	private Pane buildLevelProgressionWindow(){
		myProgressionWindow = new LevelProgressionWindow();
		return myProgressionWindow.getWindow();
	}
	
	private Pane buildLevelSelectionWindow(){
		mySelectionWindow = new LevelSelectionWindow();
		return mySelectionWindow.getWindow();
	}

	
	public Pane getPane(){
		return myPane;
	}
	
	@Override
	public String toString(){
		return "Level Editor";
	}
	
}
