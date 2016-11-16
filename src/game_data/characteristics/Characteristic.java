package game_data.characteristics;

public interface Characteristic {
	
	
	/**
	 * Method implemented by all characteristics (i.e. breakable, movable etc.). What happens for each characteristic every
	 * time step. 
	 * 
	 * @author Austin Gartside
	 */
	public void express();
	
	public Characteristic copy();

}
