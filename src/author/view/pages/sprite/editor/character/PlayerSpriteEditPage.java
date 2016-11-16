package author.view.pages.sprite.editor.character;

import author.view.pages.sprite.SpriteEditWindow;
import game_data.Player;
import game_data.Sprite;
import javafx.scene.control.Button;

public class PlayerSpriteEditPage extends CharacterSpriteEditor {

	public PlayerSpriteEditPage() {
		super();
		Button but = new Button("open window");
		but.setOnMouseClicked(e -> new SpriteEditWindow().openWindow() );
		super.getToolBarBuilder().addBurst(but);
	}
	
	public PlayerSpriteEditPage(Sprite aSprite){
		super(aSprite);
	}

	@Override
	public String getName() {
		return "Player Editor";
	}

	@Override
	public Sprite buildSprite() {
		return new Player(super.getLocation(), super.getImageFile().toString());
	}

}
