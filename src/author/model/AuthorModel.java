/**
 * 
 */
package author.model;

import java.util.HashSet;
import java.util.Set;

import author.model.presets.ISpritePreset;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class AuthorModel implements IAuthorModel{

	private Set<ISpritePreset> spritePresets = new HashSet<>();
	/**
	 * 
	 */
	public AuthorModel() {
		// TODO Auto-generated constructor stub
	}

}
