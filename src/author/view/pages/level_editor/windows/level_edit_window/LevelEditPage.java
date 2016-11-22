/**
 * 
 */
package author.view.pages.level_editor.windows.level_edit_window;

import game_data.Level;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
class LevelEditPage {

	
	private Pane container;
	
	LevelEditPage() {
		
	}
	
	LevelEditPage(Level aLevel){
		this();
		
	}
	
	public Pane getPane(){
		return this.container;
	}
	
	public Level getLevel(){
		
	}

}
