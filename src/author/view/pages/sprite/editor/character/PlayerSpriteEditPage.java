package author.view.pages.sprite.editor.character;

import author.view.pages.sprite.SpriteEditWindow;
import game_data.Sprite;
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
	public String getSpriteType() {
		return "Player Editor";
	}

	@Override
	public Sprite buildSprite() {
		getSprite().setMyLocation(super.getLocation());
		getSprite().setMyImagePath(super.getImageFile().toString());
		getSprite().setMyWidth(super.getWidth());
		getSprite().setMyHeight(super.getHeight());
		getSprite().setName(super.getSpriteName());

		return getSprite();
	}

}
