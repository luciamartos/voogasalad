package author.view.pages.sprite.editor;

import java.io.File;

import author.view.util.ToolBarBuilder;
import game_data.Location;
import game_data.Sprite;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Abstract class for Sprite viewing and editing
 * 
 * 
 * @author George Bernard
 */
public abstract class BaseSpriteEditPage {
	private Pane myPane;
	private ToolBarBuilder myToolBarBuilder;
	
	private Sprite mySprite;
	private BaseSpriteEditBox mySpriteEditBox;
	
	public BaseSpriteEditPage(){
		myPane = new VBox();
		myToolBarBuilder = new ToolBarBuilder();
		mySpriteEditBox = new BaseSpriteEditBox();
		myPane.getChildren().addAll(myToolBarBuilder.getToolBar(), mySpriteEditBox.getPane());
		myToolBarBuilder.addBurst(new Label(getName()));
	}

	public BaseSpriteEditPage(Sprite aSprite){
		mySprite = aSprite;
		mySpriteEditBox.setLocation(aSprite.getMyLocation());
		mySpriteEditBox.setImageFile(new File(aSprite.getMyImagePath()));
	}
	
	public abstract Sprite buildSprite();
	
	public abstract String getName();

	public Pane getPane(){
		return myPane;
	}
	
	protected final boolean hasSprite(){
		return mySprite == null;
	}

	protected final File getImageFile(){
		return mySpriteEditBox.getImageFile();
	}
	
	protected final Location getLocation(){
		return mySpriteEditBox.getLocation();
	}
	
	protected ToolBarBuilder getToolBarBuilder(){
		return myToolBarBuilder;
	}


}
