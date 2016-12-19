
// This entire file is part of my masterpiece.
// Ted Marchildon

/**
 * Implements the factory for stored games
 */
package gameplayer.back_end.stored_games;

public class StoredGameFactory {

	public IStoredGames create() {
		return new StoredGames();
	}
}
