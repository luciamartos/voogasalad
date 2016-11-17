package game_engine;

import game_data.Location;
import game_data.Sprite;
import javafx.scene.image.Image;

public interface IGameWideCollisionEffectsInterface {
	public void createNewSprite(Location relativeSpriteLocation, Image SpriteImage, Location referenceLocation, SpriteType myType);
	public void removeSprite(Sprite sprite);
	public void invokeLevelLoss();
	public void invokeLevelWin();
}
