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
		levelEditPage = new LevelEditPage();
	}
	
	public LevelEditWindow(Level aLevel){
		levelEditPage = new LevelEditPage(aLevel);
	}
	
	private void initializeWindow(){
		this.stage = new Stage();
		stage.setTitle(TITLE);
		stage.setScene(new Scene(levelEditPage.getPane()));
		stage.setResizable(false);
		stage.show();
	}
	
}
