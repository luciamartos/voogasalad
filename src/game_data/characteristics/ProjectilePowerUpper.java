package game_data.characteristics;

/**
 * @author austingartside
 *
 */
public class ProjectilePowerUpper extends PowerUpper implements Characteristic{

	public ProjectilePowerUpper(){
		//nothing? unless we want to have different projectile types
		//make your character a launcher
	}
	
	@Override
	public Characteristic copy() {
		return new ProjectilePowerUpper();
	}

}
