/**
 * 
 */
package game_data.game_maker;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class GameMakerFactory {

	/**
	 * 
	 */
	public GameMakerFactory() {
		// Empty On Purpose
	}
	
	public IGameMaker create(){
		return new GameMaker();
	}

}
