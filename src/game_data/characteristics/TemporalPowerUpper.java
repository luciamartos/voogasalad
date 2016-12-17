package game_data.characteristics;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_engine.IUpdateStatesAndPowerUps;
import game_engine.UpdateStates;

/**
 *@author Lucia Martos
 */

@NameAnnotation(name = "Temporal Power Up")
public abstract class TemporalPowerUpper extends PowerUpper implements Characteristic, ICharactericticAction {
		
	@ParameterAnnotation(parameters = {"Sprite"})
	public TemporalPowerUpper(Sprite aSprite){
		super(aSprite);
	}
	
	
	public abstract void reversePowerUp(Sprite playerSprite,IUpdateStatesAndPowerUps myInterface);
	
	public abstract void activatePowerUp(Sprite palyerSprite, IUpdateStatesAndPowerUps myInterface, Double timeElapsed);
	
//	public abstract void initializePowerUp(Sprite playerSprite);
	
	public void addToPowerUpMap(Sprite collidedSprite, double myTimeInEffect){

		boolean hasChanged = false;
		for(Characteristic characteristic: collidedSprite.getPowerUps().keySet()){
			hasChanged = checkForSpecificTemporalPowerUpper(collidedSprite, myTimeInEffect, hasChanged, characteristic);
		}
		if(!hasChanged) {
//			if(this == null) System.out.println("Austin is right");
			collidedSprite.getPowerUps().put(this, myTimeInEffect);
//			System.out.println("second if");
		}
		
//		collidedSprite.setPowerUps(collidedSprite.getPowerUps());
//		System.out.println("map size later  "+collidedSprite.getPowerUps().size());

	}


	public abstract boolean checkForSpecificTemporalPowerUpper(Sprite collidedSprite, double myTimeInEffect, boolean hasChanged,
			Characteristic characteristic);
	
	public ICharactericticAction getInterface(){
		return this;
	}
	

}
