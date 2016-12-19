package gameplayer.back_end.stored_games;

public class StoredGameFactory {

	public IStoredGames create() {
		return new StoredGames();
	}
}
