// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)
package author.view.util.undo;

import game_data.Level;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class RevertManagerFactory {

	/**
	 * 
	 */
	public RevertManagerFactory() {
		// Do Nothing
	}
	
	public IRevertManager create(Level aLevel){
		return new ConcreteRevertManager(aLevel);
	}

}
