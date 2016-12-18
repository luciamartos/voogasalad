// This entire file is part of my masterpiece
// Austin Gartside
/*
 * This is the associated action for the impassable characteristic. This also implements an interface. Much like how 
 * characteristcs are great because engine need only call their execute function, actions are great as well because the
 * characteristic need only call the act method. This separation of functionality makes it easy to edit and error check both
 * actions and characteristics. Additionally, it separates out functionality, which makes reading the code and identifying
 * sources of problems much easier. In terms of this internal design it is very clean thanks to the side hierarchy.
 * Originally there was an if tree in the act method to determine which type if impassable should happen based on the side.
 * With the Impassable characteristic I only need the side and one line of code to call the proper method. In this way
 * we avoid an if tree here and in every other method that uses side. This makes for a large reduce in repeated code as well
 * as much readable code. This entire structure is great because it allows users to easily define characteristcs and actions
 * that are side-dependent.
 */
package game_engine.actions;
import game_data.Sprite;
import game_engine.Side;

public class Hit implements Action {
	
	private Sprite myPlayerSprite;
	private Sprite myNonPlayerSprite;
	private Side mySide;
	

	public Hit(Sprite player,  Side aSide, Sprite nonPlayerSprite) {
		myPlayerSprite = player;
		myNonPlayerSprite = nonPlayerSprite;
		mySide = aSide;
	}
	
	@Override
	public void act() {
		mySide.hitImpassable(myPlayerSprite);
	}

	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new Hit(aSprite, mySide, myNonPlayerSprite);
	}
		
}