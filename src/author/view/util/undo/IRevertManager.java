// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)

/* 
 * This is the external API for my undo functionality in the front end. As is custom in
 * API design, this interface exposes only the necessary methods to the user while
 * keeping the implementation details hidden.
 */
package author.view.util.undo;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public interface IRevertManager {

	public void undo();
	
	public void redo();
	
}
