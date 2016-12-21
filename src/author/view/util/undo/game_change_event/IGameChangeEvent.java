/**
 * 
 */
package author.view.util.undo.game_change_event;

import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IGameChangeEvent <T extends Observable>{

	public Boolean undo();
	
	public Boolean redo();
	
	public void removeListener();
	
	public T getObservable();
	
}
