package game_engine.actions;

import game_data.Sprite;
import game_data.characteristics.Characteristic;
import game_data.characteristics.Damager;
import game_data.characteristics.ICharactericticAction;
import game_data.characteristics.InvincibilityPowerUpper;
import game_data.states.*;
import game_engine.GameResources;
import game_engine.UpdateStates;

//This entire file is part of my masterpiece.
//LUCIA MARTOS
/**
 * This shows the action class damage and how easy it is to add the temporal
 * power up on invincibility after executing this action
 * 
 * 
 * @author Lucia Martos
 */

public class Damage extends PointsChanger implements Action {
	private int myDamage;

	public Damage(int damage, Sprite damageTaker) {
		super(damage, damageTaker);
		myDamage = damage;
	}

	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new Damage(myDamage, aSprite);
	}

	@Override
	public void act() {
		boolean hasHealth = false;
		boolean isVincible = false;
		State health = null;

		for (State state : spriteAffected.getStates()) {
			if (state instanceof Health) {
				health = state;
				hasHealth = true;
			}
			if (state instanceof Vincibility && ((Vincibility) state).isVincibility())
				isVincible = true;
		}

		if (hasHealth && isVincible) {
			((Health) health).updateState(pointsToGive);
			InvincibilityPowerUpper invincibility = new InvincibilityPowerUpper(
					GameResources.RECOVERY_TIME.getDoubleResource(), spriteAffected);
			invincibility.addToPowerUpMap(spriteAffected, GameResources.RECOVERY_TIME.getDoubleResource());
		}

	}

}
