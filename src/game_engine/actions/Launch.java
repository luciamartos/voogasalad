// This entire file is part of my masterpiece.
// Katrina Zhu
package game_engine.actions;
/**
 * The Launch Interface represents any action that seeks to launch a projectile.
 * 
 * @author Katrina Zhu
 */
public interface Launch extends Action {
	
	/**
	 * Returns the velocity at which the projectile is being launched.
	 */
	public double getVelocity();
}
