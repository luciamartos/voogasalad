package author.view.pages.level_editor.windows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import author.controller.IAuthorController;
import javafx.application.Platform;

public class LevelWindowFactory {

	public static final String WINDOWS_PATH = "author.view.pages.level_editor.windows.";
	
	public LevelWindowFactory() {

	}

	public AbstractLevelEditorWindow create(String name, IAuthorController authorController) {
		Class<?> c = null;
		Constructor<?> constructor = null;
 		try {
			c = Class.forName(WINDOWS_PATH + name);
			constructor = c.getConstructors()[0];
		} catch (ClassNotFoundException e) {
			// TODO: Jordan(vooga) - handle class not found exception
			e.printStackTrace();
		}
		AbstractLevelEditorWindow window = null;
		try {
			window = (AbstractLevelEditorWindow) constructor.newInstance(new Object[] {authorController});
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			Platform.exit();
		}
		return window;
	}
}
