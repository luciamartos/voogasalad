/**
 * 
 */
package author.view.pages.level_editor.windows.level_edit_window;

import game_data.Level;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class LevelEditWindow{
	private Stage stage;
	private static final String TITLE = "New Level";
	private LevelEditPage levelEditPage;
	
	public LevelEditWindow(){
		this.levelEditPage = new LevelEditPage();
		initializeWindow();
	}
	
	public LevelEditWindow(Level aLevel){
		this.levelEditPage = new LevelEditPage(aLevel);
		initializeWindow();
	}
	
	public Level getLevel(){
		return this.levelEditPage.getLevel();
	}
	
	private void initializeWindow(){
		this.stage = new Stage();
		this.stage.setTitle(TITLE);
		this.stage.setScene(new Scene(this.levelEditPage.getPane()));
		this.stage.setResizable(false);
		this.stage.show();
	}
	
}
