package game_data.characteristics;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_engine.IUpdateStatesAndPowerUps;

//This entire file is part of my masterpiece.
//LUCIA MARTOS
/**
 * This is the superclass of Temporal Power Ups which is an extension of
 * PowerUppers and it is a type of characteristic The reason why I think this is
 * a good class for the master people is because it shows the functionality of
 * temporal power ups these are a type of characteristic which activates a
 * de-activates power ups. This representative of how the characteristics work
 * in our project. It shows my understanding of inheritance and hierarchies. I
 * try to minimize code repetition by making all the generic temporal power up
 * code here, like adding to the power up map
 * 
 * @author Lucia Martos
 */

@NameAnnotation(name = "Temporal Power Up")
public abstract class TemporalPowerUpper extends PowerUpper implements Characteristic, ICharactericticAction {

	@ParameterAnnotation(parameters = { "Sprite" })
	public TemporalPowerUpper(Sprite aSprite) {
		super(aSprite);
	}

	public abstract void reversePowerUp(Sprite playerSprite);

	public abstract void maintainPowerUp(Sprite palyerSprite);

	public void addToPowerUpMap(Sprite collidedSprite, double myTimeInEffect) {
		for (Characteristic characteristic : collidedSprite.getPowerUps().keySet()) {
			if (!updateMapIfPowerUpExists(collidedSprite,myTimeInEffect, characteristic))
				collidedSprite.getPowerUps().put(this, myTimeInEffect);
		}
	}

	public abstract boolean updateMapIfPowerUpExists(Sprite collidedSprite, double myTimeInEffect,
			Characteristic characteristic);


}
