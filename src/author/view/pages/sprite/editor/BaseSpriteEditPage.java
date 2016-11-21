package author.view.pages.sprite.editor;

import java.io.File;

import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import game_data.Location;
import game_data.Sprite;
import javafx.scene.control.Button;
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
		Button buildButton = new ButtonFactory().createButton("build", e -> buildSprite()).getButton();
		myToolBarBuilder.addBurst(new Label(getName(), buildButton));

	}

	public BaseSpriteEditPage(Sprite aSprite){
		this();
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

	protected Sprite getSprite(){
		return mySprite;
	}

}
