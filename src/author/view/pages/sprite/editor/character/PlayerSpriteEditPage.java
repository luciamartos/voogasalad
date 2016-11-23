package author.view.pages.sprite.editor.character;

import author.view.pages.sprite.SpriteEditWindow;
import game_data.Sprite;
import game_data.sprites.Player;
import javafx.scene.control.Button;

public class PlayerSpriteEditPage extends CharacterSpriteEditPage {

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
		getSprite().setMyLocation(super.getLocation());
		getSprite().setMyImagePath(super.getImageFile().toString());
		// fixed this temporarily to resolve conflict, hard coded values need to go away somehow
		return new Player(super.getLocation(), 20, 20, "Mario", super.getImageFile().toString());
	}

}
