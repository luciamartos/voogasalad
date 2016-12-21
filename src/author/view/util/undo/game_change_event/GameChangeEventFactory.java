/**
 * 
 */
package author.view.util.undo.game_change_event;

import author.view.util.undo.IRevertManagerInternal;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class GameChangeEventFactory {

	/**
	 * 
	 */
	public GameChangeEventFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public IGameChangeEvent<Sprite> create(Sprite sprite, IRevertManagerInternal<Sprite> iRevertManagerInternal){
		return new ConcreteGameChangeEvent(sprite, iRevertManagerInternal);
	}

}
