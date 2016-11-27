/**
 * 
 */
package author.view.pages.level_editor.windows.level_edit_window;

import author.view.util.ToolBarBuilder;
import game_data.Level;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
class LevelEditPage {

	
	private Pane container;
	private LevelEditBox levelEditBox;
	private ToolBarBuilder toolBarBuilder;
	
	LevelEditPage() {
		this.levelEditBox = new LevelEditBox();
		initPane();
	}
	
	LevelEditPage(Level aLevel){
		this.levelEditBox = new LevelEditBox(aLevel);
		initPane();
	}
	
	private void initPane(){
		this.container = new Pane();
		this.container.getChildren().addAll(this.toolBarBuilder.getToolBar(), this.levelEditBox.getEditBox());
	}
	
	public Pane getPane(){
		return this.container;
	}
	
	public Level getLevel(){
		return this.levelEditBox.getLevel();
	}

}
