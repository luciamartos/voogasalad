package game_engine.actions;

import game_data.Sprite;
import game_data.characteristics.Characteristic;
import game_data.characteristics.Damager;
import game_data.characteristics.ICharactericticAction;
import game_data.characteristics.InvincibilityPowerUpper;
import game_data.states.*;
import game_engine.GameResources;
import game_engine.UpdateStates;


public class Damage extends PointsChanger implements Action {
	private int myDamage;
	
	public Damage(int damage, Sprite damageTaker){
		super(damage, damageTaker);
		myDamage = damage;
	}
	
	@Override
	public Action copyWithNewSprite(Sprite aSprite) {
		return new Damage(myDamage, aSprite);
	}
	
	@Override
	public void act() {
		//looop through all states, if it contains health check boolean 
		boolean hasHealth = false;
		State health = null;
		boolean isInvincible = false; 
//		System.out.println("HeLLOOOO");
		for(State i : spriteAffected.getStates()){
			if (i instanceof Health){
				hasHealth = true;
				health = i;
			}
				else if(i instanceof Vincibility){
					if(!((Vincibility) i).isVincibility())
						isInvincible = true;
				}
			
		}
		
		if(!isInvincible && hasHealth){
			((Health) health).updateState(pointsToGive);
			InvincibilityPowerUpper invincibility = new InvincibilityPowerUpper(GameResources.RECOVERY_TIME.getDoubleResource(), spriteAffected);
			spriteAffected.addCharacteristic(invincibility);
			invincibility.getInterface().addToPowerUpMap(spriteAffected, GameResources.RECOVERY_TIME.getDoubleResource());
//			UpdateStates.activateSingularPowerUp(invincibility, spriteAffected, GameResources.RECOVERY_TIME.getDoubleResource());
			if(((Health) health).getMyHealth()<=0){
				((Health) health).kill();
			}
		}
		
	}

}
