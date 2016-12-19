
package game_data.characteristics;

import java.util.Map;
import game_engine.Side;
import game_data.Level;
import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_data.characteristics.characteristic_annotations.ViewableMethodOutput;
import game_data.sprites.Player;
import game_data.states.State;
import game_data.states.Vincibility;
import game_data.states.Visible;
import game_engine.GameResources;
import game_engine.IUpdateStatesAndPowerUps;
import game_engine.UpdateStates;
import game_engine.actions.Action;
import game_engine.actions.Invincibility;
import game_engine.actions.SpeedBoost;
//import javafx.geometry.Side;

//This entire file is part of my masterpiece.
//LUCIA MARTOS
/**
 * This is an example of a temporal power upper (invincibility one) which give
 * the sprite invincibility for a given number of seconds and it also makes it
 * flash so the user know he has entered this mode.
 * 
 * Here I am interacting with states of the sprite to make him invincible (so
 * that it cannot get affected by damage) and to change its visibility on the
 * screen.
 * 
 * 
 * @author Lucia Martos
 *
 */

@NameAnnotation(name = "Invincibility PowerUp")
public class InvincibilityPowerUpper extends TemporalPowerUpper implements Characteristic {

	private double myTimeInEffect;
	private Action myAction;

	@ParameterAnnotation(parameters = { "Time In Effect", "Sprite" })
	public InvincibilityPowerUpper(double timeInEffect, Sprite aSprite) {
		super(aSprite);
		myTimeInEffect = timeInEffect;
	}

	@ViewableMethodOutput(description = "Time In Effect", type = double.class)
	public double getTimeInEffect() {
		return myTimeInEffect;
	}

	@Override
	public Characteristic copy(Sprite aSprite) {
		return new InvincibilityPowerUpper(myTimeInEffect, aSprite);
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		for (Sprite collidedSprite : myCollisionMap.keySet()) {
			if (collidedSprite instanceof Player) {
				addToPowerUpMap(collidedSprite, myTimeInEffect);
				myAction = new Invincibility(collidedSprite);
				myAction.act();
			}
		}
	}

	@Override
	public void reversePowerUp(Sprite playerSprite) {
		for (State state : playerSprite.getStates()) {
			if (state instanceof Vincibility)
				((Vincibility) state).setVincibility(true);
			if (state instanceof Visible)
				((Visible) state).setVisibility(true);
		}

	}

	@Override
	public void maintainPowerUp(Sprite playerSprite) {
		double timeElapsed = playerSprite.getPowerUps().get(this);
		boolean hasVisibility = false;
		for (State state : playerSprite.getStates()) {
			if (state instanceof Visible) {
				((Visible) state).setVisibility(timeElapsed % GameResources.FLASH_RATE.getDoubleResource() == 0);
				hasVisibility = true;
			}
		}
		if (!hasVisibility) 
			playerSprite.addState(new Visible(timeElapsed % GameResources.FLASH_RATE.getDoubleResource() == 0));
		
	}

	@Override
	public boolean updateMapIfPowerUpExists(Sprite collidedSprite, double myTimeInEffect, Characteristic characteristic) {
		if (characteristic instanceof InvincibilityPowerUpper) {
			collidedSprite.getPowerUps().put(this, myTimeInEffect);
			return true;
		}
		return false;
	}

}