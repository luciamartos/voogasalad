package game_engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game_data.Sprite;
import javafx.geometry.Side;

public class ListOfCollidingSprites {
	
	private Sprite targetSprite;
	private List<Sprite> spriteList;
	private Map<Sprite, Side> collisionSprites;

	public ListOfCollidingSprites(Sprite targetSprite, List<Sprite> spriteList) {
		this.targetSprite =targetSprite;
		this.spriteList = spriteList;
		
		getListOfSpritesCollided();
	}
	
	private Map<Sprite, Side> getListOfSpritesCollided(){
		collisionSprites = new HashMap<Sprite, Side>();
		
		for(Sprite mySprite:spriteList){
			if(mySprite != targetSprite && mySprite.getImageView().getBoundsInLocal().interects(targetSprite.getImageView().getBoundsInLocal())){
				collisionSprites.put(mySprite, findSideOfCollission(mySprite, targetSprite));
			}
		}	
		return collisionSprites;
	}

	private  Side findSideOfCollission(Sprite mySprite, Sprite targetSprite) {
		if(mySprite.getMyLocation().getYLocation() <= targetSprite.getMyLocation().getYLocation()){
			return Side.BOTTOM;
		}
		if(mySprite.getMyLocation().getYLocation() >= targetSprite.getMyLocation().getYLocation() + targetSprite.getHeight()){
			return Side.TOP;
		}
		if(mySprite.getMyLocation().getXLocation() < targetSprite.getMyLocation().getXLocation()){
			return Side.LEFT;
		}
		if(mySprite.getMyLocation().getXLocation() > targetSprite.getMyLocation().getXLocation()){
			return Side.RIGHT;
		}
		
	}
	
	public Map<Sprite, Side> getCollisionSpriteMap(){
		return this.collisionSprites;
	}

}
