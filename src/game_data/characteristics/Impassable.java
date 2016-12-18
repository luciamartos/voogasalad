// This entire file is part of my masterpiece
// Austin Gartside
/*
 * The Impassable characteristic is an example of one of the many characteristics that our game has. This class shows off the 
 * general structure of a characteristic and why it works so well with authoring and engine. For authoring, the annotations
 * are extremely useful in that authoring automaticaly knows what constructor to call, what input it needs, and what type
 * of field to generate. These annotations make it so that if I made a new characteristic and added these annotations along
 * with a resource file entry, it would automatically show up as an option to give to sprites. This makes the characteristics
 * extremely easy to implement and extend. Additionally, it shows off the composition structure in the sprite. The sprite
 * contains many of these, and they all have copy and execute functions. With this, engine can just have one line that 
 * calls the execute and that is all that's needed. Additionally it gets necessary collision information. The copy method
 * makes it really easy for users to copy sprites in authoring so they don't have to drag and drop and customize all the time.
 * The design is really clean yet very powerful as it uses minimal code through an associated action, which makes it easy 
 * to read. Overall characteristics are very extensible as well as they all have the exact same format. 
 */
package game_data.characteristics;
import java.util.Map;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_engine.Side;
import game_engine.actions.Action;
import game_engine.actions.Hit;

@NameAnnotation(name = "Impassable")
public class Impassable implements Characteristic{
	
	private Sprite mySprite;
	private boolean movesThroughBottom;
	private Action myAction;
	
	@ParameterAnnotation(parameters={"Sprite"})
	public Impassable(Sprite aSprite){
		mySprite = aSprite;
	}
	
	
	@Override
	public void execute(Map<Sprite, Side> myCollisionMap){
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			myAction = new Hit(collidedSprite, myCollisionMap.get(collidedSprite), mySprite);
			myAction.act();
		}
	}

	@Override
	public Characteristic copy(Sprite aSprite) {
		return new Impassable(aSprite);
	}

}
