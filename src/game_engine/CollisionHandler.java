package game_engine;

import game_data.Sprite;
import javafx.geometry.Side;

public class CollisionHandler {
	private IGameWideCollisionEffectsInterface myInterface;
	// TODO: need SpriteType class that contains info
	// TODO: create controller that extends 
	// Notes: does not need "game score since every sprite has their score and
	// that can be determined later what defines the global score
	// need to create the controller and implement

	public CollisionHandler(Sprite spriteOne, Sprite spriteTwo, Side sideOne, Side sideTwo,
			IGameWideCollisionEffectsInterface myInterface) {
		this.myInterface = myInterface;

		handleIndividualCollisionEffects(spriteOne, sideOne);
		handleIndividualCollisionEffects(spriteTwo, sideTwo);

		handleDependentCollisionEffects(spriteOne, spriteTwo, sideOne, sideTwo);

	}

	private void handleDependentCollisionEffects(Sprite spriteOne, Sprite spriteTwo, Side sideOne, Side sideTwo) {
		updateSpriteLife(spriteOne, spriteTwo);
		updateSpriteScore(spriteOne, spriteTwo);
	}

	private void handleIndividualCollisionEffects(Sprite sprite, Side side) {
		checkFlashImage(sprite);
		checkBreakSprite(sprite);
		checkCreateSprite(sprite, side);
		checkGameLoss(sprite);
		checkGameWin(sprite);
	}

	// VERY QUESTIONABLE CODE. do we even need this? can it not just go on the
	// update method?
	private void checkGameLoss(Sprite sprite) {
		if (sprite.checkLossCondition()) {
			myInterface.invokeLevelLoss();
		}
	}

	private void checkGameWin(Sprite sprite) {
		if (sprite.checkWinCondition()) {
			myInterface.invokeLevelWin();
		}
	}

	private void checkFlashImage(Sprite sprite) {
		if (sprite.getType().isFlashImageCreator()) {
			myInterface.createFlashImageOnScreen(sprite.getType().getFlashImageTime(), sprite.getType().getFlashImage(),
					sprite.getType().getFlashImageLocation(), sprite.getType().getFlashImageSize());
		}
	}

	private void checkBreakSprite(Sprite sprite) {
		if (sprite.getType().isBreakAfterCollision()) {
			myInterface.removeSprite(sprite);
		}
	}

	private void checkCreateSprite(Sprite sprite, Side side) {
		if (sprite.getType().isCollisionSpriteCreated(side)) {
			myInterface.createNewSprite(sprite.getType().getCollisionSpriteCreatedRelativeLocation(side),
					sprite.getType().getCollisionSpriteCreatedImage(side), sprite.getMyLocation(),
					sprite.getType().getCollisionSpriteCreatedType(side));
		}

	}

	private void updateSpriteLife(Sprite spriteOne, Sprite spriteTwo) {
		updateSpriteLifeBothSprites(spriteOne, spriteTwo);
		updateSpriteLifeBothSprites(spriteTwo, spriteOne);
	}

	private void updateSpriteLifeBothSprites(Sprite spriteOne, Sprite spriteTwo) {
		if (spriteOne.getType().getTakeLife() != 0) {
			spriteTwo.setLife(spriteTwo.getLife() - spriteOne.getType().getTakeLife());
		}
	}

	private void updateSpriteScore(Sprite spriteOne, Sprite spriteTwo) {
		updateSpriteScoreBothSprites(spriteOne, spriteTwo);
		updateSpriteScoreBothSprites(spriteTwo, spriteOne);
	}

	private void updateSpriteScoreBothSprites(Sprite spriteOne, Sprite spriteTwo) {
		if (spriteOne.getType().getGiveScore() != 0) {
			spriteTwo.setScore(spriteTwo.getScore() - spriteOne.getScore().getGiveScore());
		}
	}

}
