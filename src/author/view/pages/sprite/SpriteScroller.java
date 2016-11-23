package author.view.pages.sprite;

import author.model.presets.TestSprite;
import author.view.util.TabPaneFacade;
import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SpriteScroller {

	private ScrollPane myScroll;
	private Pane myColumn;
	
	public SpriteScroller(String aScrollType) {
		myScroll = new ScrollPane();
		myColumn = new VBox();
		
		Pane content = new VBox();
		myScroll.setContent(content);
		myScroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		content.getChildren().addAll(buildToolbar(aScrollType), myColumn);
		addPresets();
	}

	public Node getNode(){
		return myScroll;
	}
	
	private Node buildToolbar(String aScrollType){
		ToolBarBuilder toolBarBuilder = new ToolBarBuilder();
		toolBarBuilder.addBurst(new Label(aScrollType));
		toolBarBuilder.addBurst(new Button("New"));
		
		return toolBarBuilder.getToolBar();
	}

	private void addPresets(){
		for ( TestSprite ts : TestSprite.values()) {
			myColumn.getChildren().add( new SpriteViewBox( ts.getSprite() ).getNode() );
		}
	}
	
}
