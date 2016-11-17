package author.view.pages.level_editor.windows;

public class LevelWindowFactory {
	
	public LevelWindowFactory() {
		
	}
	
	public AbstractLevelEditorWindow create(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class c = Class.forName("author.view.pages.level_editor.windows." + name);
		AbstractLevelEditorWindow window = (AbstractLevelEditorWindow) c.newInstance();
		return window;
	}
}
