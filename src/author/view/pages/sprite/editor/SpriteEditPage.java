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
public abstract class SpriteEditPage {
	private Pane myPane;
	private ToolBarBuilder myToolBarBuilder;
	
	private Sprite mySprite;
	private SpriteEditBox mySpriteEditBox;

	public SpriteEditPage(){
		myPane = new VBox();
		myToolBarBuilder = new ToolBarBuilder();

		myPane.getChildren().add(myToolBarBuilder.getToolBar());
		myToolBarBuilder.addBurst(new Label(getName()));
		addGeneralSpriteEdit();
	}

	public SpriteEditPage(Sprite aSprite){
		mySprite = aSprite;
	}
	
	public abstract Sprite buildSprite();
	
	public abstract String getName();

	public Pane getPane(){
		return myPane;
	}

	private void addGeneralSpriteEdit(){
		SpriteEditBox generalEditBox = new SpriteEditBox();
		getPane().getChildren().add(generalEditBox.getPane());
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
