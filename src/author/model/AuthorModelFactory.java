/**
 * 
 */
package author.model;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public class AuthorModelFactory {

	/**
	 * 
	 */
	public AuthorModelFactory() {
		// TODO Nothing On Purpose
	}
	
	public IAuthorModel create(){
		return new ConcreteAuthorModel();
	}

}
