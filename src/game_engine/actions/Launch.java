// This entire file is part of my masterpiece.
// Katrina Zhu
package game_engine.actions;
/**
 * The Launch Interface represents any action that seeks to launch a projectile.
 * This is an important interface to not only identify specific launch actions,
 * but to implement the method getVelocity() of the launch actions.
 * @author Katrina Zhu
 */
public interface Launch extends Action {
	
	/**
	 * Returns the velocity at which the projectile is being launched.
	 */
	public double getVelocity();
}
