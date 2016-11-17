package author.view.pages.level_editor.windows;

import javafx.application.Platform;

public class LevelWindowFactory {
	
	public static final String WINDOWS_PATH = "author.view.pages.level_editor.windows.";
	
	public LevelWindowFactory() {
		
	}
	
	public AbstractLevelEditorWindow create(String name) {
		Class c = null;
		try {
			c = Class.forName(WINDOWS_PATH + name);
		} catch (ClassNotFoundException e) {
			// TODO: Jordan(vooga) - handle class not found exception
			e.printStackTrace();
		}
		AbstractLevelEditorWindow window = null;
		try {
			window = (AbstractLevelEditorWindow) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			Platform.exit();
		}
		return window;
	}
}
