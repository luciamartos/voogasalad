// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)
package author.view.util.undo;

import author.view.util.undo.game_change_event.IGameChangeEvent;
import javafx.beans.Observable;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IRevertManagerInternal <V extends Observable>{

	public void addHistory(IGameChangeEvent<V> gameChangeEvent);
	
	public void addFuture(IGameChangeEvent<V> gameChangeEvent);

}
