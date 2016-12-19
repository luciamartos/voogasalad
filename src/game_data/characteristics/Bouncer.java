package game_data.characteristics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_data.characteristics.characteristic_annotations.ViewableMethodOutput;
import game_data.sprites.Player;
import game_engine.Bottom;
import game_engine.Side;
import game_engine.Top;
import game_engine.actions.Action;
import game_engine.actions.Bounce;
import game_engine.actions.MoveLeft;
import game_engine.actions.MoveRight;
import game_engine.actions.MoveUpJump;
//import javafx.geometry.Side;
import javafx.scene.input.KeyCode;

/**
 * @author Austin, Katrina
 *
 */


@NameAnnotation(name = "Bouncer")
public class Bouncer implements Characteristic {
	private Side bouncingSpriteSide;
	private double myBounceSpeedHorizontal;
	private double myBounceSpeedVertical;
	private Sprite mySprite;
	private Action myAction;
	private Sprite bouncingSprite;
	private boolean bouncing=false;
	private int timeAfterCollisionCount=0;
	private static final int TOTAL_TIME_AFTER_COLLISION=50;
	private Map<KeyCode, Action> originalKeyPressedMap;
	@ParameterAnnotation(parameters = { "Horizontal Bounce Speed", "Vertical Bounce Speed", "Sprite" })
	public Bouncer(double bounceSpeedHorizontal, double bounceSpeedVertical, Sprite mySprite) {
		myBounceSpeedHorizontal = bounceSpeedHorizontal;
		myBounceSpeedVertical=bounceSpeedVertical;
		originalKeyPressedMap=null;
	}

	@ViewableMethodOutput(description="Horizontal Bounce Speed", type=double.class)
	public double getBounceSpeedHorizontal() {
		return myBounceSpeedHorizontal;
	}
	
	@ViewableMethodOutput(description="Vertical Bounce Speed", type=double.class)
	public double getBounceSpeedVertical(){
		return myBounceSpeedVertical;
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		for (Sprite collidedSprite : myCollisionMap.keySet()) {
			if (collidedSprite instanceof Player) {
				myAction = new Bounce(myBounceSpeedHorizontal, myBounceSpeedVertical, collidedSprite, myCollisionMap.get(collidedSprite));
				myAction.act();
				timeAfterCollisionCount=0;
				bouncing=true;
				bouncingSprite=collidedSprite;
				bouncingSpriteSide=myCollisionMap.get(bouncingSprite);
				if(originalKeyPressedMap==null){
					originalKeyPressedMap=new HashMap<KeyCode, Action>(bouncingSprite.getControllable().getMyKeyPressedMap());
				}
			}			
		}
		if(bouncing && bouncingSpriteSide.isHorizontal()){
			resetControls();
		}	
		if(timeAfterCollisionCount>TOTAL_TIME_AFTER_COLLISION){
			finishBouncing();
		}
	}
	private void resetControls(){
		timeAfterCollisionCount++;
		Map<KeyCode, Action> newKeyMap = new HashMap<KeyCode, Action>(bouncingSprite.getControllable().getMyKeyPressedMap());
		//System.out.println(newKeyMap.size());
		HashSet<KeyCode> keysToRemove = new HashSet<KeyCode>();
		for (KeyCode key: newKeyMap.keySet()){
			if(newKeyMap.get(key) instanceof MoveRight || newKeyMap.get(key) instanceof MoveLeft || newKeyMap.get(key) instanceof MoveUpJump){
				keysToRemove.add(key);
			}
		}
		for(KeyCode key: keysToRemove){
			newKeyMap.remove(key);
		}
		bouncingSprite.getControllable().setMyKeyPressedMap(newKeyMap);
	}
	private void finishBouncing(){		
			bouncingSprite.setXVelocity(0);
			bouncingSprite.setYVelocity(0);
			bouncing=false;
			//System.out.println("size: " +originalKeyPressedMap.size());
			bouncingSprite.getControllable().setMyKeyPressedMap(new HashMap<KeyCode, Action>(originalKeyPressedMap));
			timeAfterCollisionCount=0;		
	}

	@Override
	public Characteristic copy(Sprite aSprite) {
		return new Bouncer(myBounceSpeedHorizontal, myBounceSpeedVertical, aSprite);
	}

}
