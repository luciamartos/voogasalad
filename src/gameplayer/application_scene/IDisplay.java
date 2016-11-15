package gameplayer.application_scene;

import javafx.scene.Scene;

/**
 * Every display must have an init method that returns a Scene
 *
 * 
 * @author tedmarchildon, hannah
 *
 */
public interface IDisplay {

	public final int SCENE_WIDTH = 1000;
	public final int SCENE_HEIGHT = 1000;
	public final int BOX_INSETS = 20;
	
	public Scene init();
	
}
