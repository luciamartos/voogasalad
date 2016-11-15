package author.view.pages.sprite_editor;

import author.view.utility.ToolBarBuilder;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Abstract class for Sprite viewing and editing
 * 
 * 
 * @author George Bernard
 */
public abstract class SpriteEditor {
	private Pane myPane;
	private ToolBarBuilder myToolBarBuilder;
	
	public SpriteEditor(){
		myPane = new VBox();
		myToolBarBuilder = new ToolBarBuilder();
		
		myPane.getChildren().add(myToolBarBuilder.getToolBar());
		myToolBarBuilder.addBurst(new Label(toString()));
	}
	
	public abstract String getName();
	
	public Pane getPane(){
		return myPane;
	}
	
	protected ToolBarBuilder getToolBarBuilder(){
		return myToolBarBuilder;
	}
	
}
