package author.view.pages.sprite;

import author.view.pages.characteristics.SpriteCharacteristicEditor;
import author.view.pages.sprite.editor.BaseSpriteEditPage;
import author.view.pages.sprite.editor.character.PlayerSpriteEditPage;
import author.view.util.TabPaneFacade;
import game_data.Sprite;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SpriteEditWindow {

	private TabPaneFacade myTabPaneFacade;
	private BaseSpriteEditPage mySpriteEditPage;
	private SpriteCharacteristicEditor mySCE;
	
	
	private SpriteEditWindow() {
		// Does Nothing
	}
	
	public SpriteEditWindow(Sprite aSprite){
		this();
		myTabPaneFacade = new TabPaneFacade();
		mySCE = new SpriteCharacteristicEditor();
		mySpriteEditPage = new PlayerSpriteEditPage(aSprite);
		
		myTabPaneFacade.addTab("Base", mySpriteEditPage.getPane());
		myTabPaneFacade.addTab("Characteristics", mySCE.getNode());
	}

	public void openWindow(){
		Stage stage = new Stage();
		stage.setTitle(mySpriteEditPage.getSpriteType());
		stage.setScene(new Scene(this.myTabPaneFacade.getTabPane()));
		stage.setResizable(false);
		stage.show();
	}
	
	public BaseSpriteEditPage getSpriteEdit(){
		return mySpriteEditPage;
	}
	
}
