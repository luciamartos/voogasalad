package author.view.pages.sprite;

import author.view.pages.sprite.editor.SpriteEditPage;
import author.view.pages.sprite.editor.character.PlayerSpriteEditPage;
import game_data.Sprite;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SpriteEditWindow {

	SpriteEditPage mySpriteEditPage;
	
	public SpriteEditWindow() {
		mySpriteEditPage = new PlayerSpriteEditPage();
	}
	
	public SpriteEditWindow(Sprite aSprite){
		mySpriteEditPage = new PlayerSpriteEditPage(aSprite);
	}

	public void openWindow(){
		Stage stage = new Stage();
		stage.setTitle(mySpriteEditPage.getName());
		stage.setScene(new Scene(mySpriteEditPage.getPane()));
		stage.setResizable(false);
		stage.show();
	}
	
	public SpriteEditPage getSpriteEdit(){
		return mySpriteEditPage;
	}
	
}
