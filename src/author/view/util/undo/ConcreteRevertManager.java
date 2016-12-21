// This entire file is part of my masterpiece.
// Cleveland Thompson V (ct168)

/*
 * This class is the top level entity for my undo functionality in the authoring
 * environment front end. This class, in combination with GameChangeEvent, represents
 * several facets of good design.
 * 
 * First, this framework relies heavily on the concept of API's and Factory Implementation.
 * From an external API perspective, RevertManagerFactory limits external access to
 * RevertManager just that through its external API (IRevertManager). Since this class is
 * package friendly, the only way to instantiate an instance of this class is through the
 * factory, which returns only the external API.
 */
package author.view.util.undo;

import java.util.Collection;
import author.view.util.undo.game_change_event.GameChangeEventFactory;
import author.view.util.undo.game_change_event.IGameChangeEvent;
import game_data.Level;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
class ConcreteRevertManager extends RevertManager<Level, Sprite>{
	/**
	 * @param managedObservable
	 */
	public ConcreteRevertManager(Level managedObservable) {
		super(managedObservable);
	}

	@Override
	protected IGameChangeEvent<Sprite> createEvent(Sprite observable) {
		return new GameChangeEventFactory().create(observable, (IRevertManagerInternal<Sprite>) this);
	}

	@Override
	protected void removeObservable(Level managedObservable, Sprite removedObservable) {
		managedObservable.removeSprite(removedObservable);
	}

	@Override
	protected Collection<Sprite> getObservables(Level managedObservable) {
		return managedObservable.getMySpriteList();
	}



}
