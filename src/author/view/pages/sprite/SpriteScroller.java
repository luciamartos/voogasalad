package author.view.pages.sprite;

import author.controller.IAuthorController;
import author.model.presets.TestSprite;
import author.view.util.TabPaneFacade;
import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import game_data.Location;
import game_data.Sprite;
import game_data.sprites.Player;
import game_data.sprites.SpriteFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SpriteScroller {

	private ScrollPane myScroll;
	private Pane myColumn;
	private IAuthorController myController;
	
	public SpriteScroller(String aScrollType, IAuthorController aController) {
		myController = aController;
		myScroll = new ScrollPane();
		myColumn = new VBox();
		
		Pane content = new VBox();
		myScroll.setContent(content);
		content.minWidthProperty().bind(myScroll.widthProperty());
		HBox.setHgrow(content, Priority.ALWAYS);
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
		toolBarBuilder.addBurst(new ButtonFactory().createButton("new", e -> {addNewSprite();}).getButton());
		
		return toolBarBuilder.getToolBar();
	}

	private void addPresets(){
		for ( TestSprite ts : TestSprite.values()) {
			myColumn.getChildren().add( new SpriteViewBox( ts.getSprite() ).getNode() );
		}
	}
	
	private void addNewSprite(){
		Sprite ns = new Player(new Location(0,0,0), 0, 0, "", "" );
		myColumn.getChildren().add(new SpriteViewBox(ns).getNode());
		myController.getModel().addSprite(ns);		
	}
	
	
}
