package gameplayer.sprite_display;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.Node;

public class SpriteDisplayController implements Iterable<Node>, ISpriteDisplay {
	
	private List<Node> mySprites;
	private SpriteDisplay mySpriteDisplay;
	
	public SpriteDisplayController() {
		this.mySprites = new ArrayList<Node>();
	}

	@Override
	public Iterator<Node> iterator() {
		  Iterator<Node> iterator = new Iterator<Node>() {

		  private int currentIndex = 0;

		  @Override
		  public boolean hasNext() {
			  return mySprites.isEmpty();
		  }

		  @Override
		  public Node next() {
			  return mySprites.get(currentIndex++);
		  }

		  @Override
		  public void remove() {
		       throw new UnsupportedOperationException();
		  }
		  };
	return iterator;
	}


	
	/*public void addSpriteToDisplay(Sprite aSprite) {
		mySprites.add(mySpriteDisplay.build(aSprite));
	}*/
	
	/*public void removeSpriteFromDisplay(Sprite aSprite) {
	 *	mySprites.remove(mySpriteDisplay.build(aSprite));
	 }*/


}
