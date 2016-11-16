package author.view.pages.level_editor;

import author.view.util.ToolBarBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This Class serves as a view for the level editor page
 * 
 * @author George Bernard
 */
public class LevelEditor {
	BorderPane myPane;
	
	public LevelEditor(){
		myPane = new BorderPane();
		myPane.setCenter(buildLevelWindow());
		myPane.setRight(buildEntityWindow());
		myPane.setBottom(buildLevelProgressionWindow());
		myPane.setLeft(buildLevelSelectionWindow());
	}
	
	private Pane buildLevelWindow(){
		Pane levelWindow = new VBox();
		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new Button("Set Background"), new Button("Set Theme"));
		levelWindow.getChildren().add(tbb.getToolBar());
		
		return levelWindow;
	}
	
	private Pane buildEntityWindow(){
		Pane entityWindow = new VBox();
		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Entity Selector"));
		entityWindow.getChildren().add(tbb.getToolBar());
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityWindow.getChildren().add(entityScroller);
		entityScroller.prefViewportHeightProperty().bind(entityWindow.heightProperty());
		
		return entityWindow;
	}
	
	private Pane buildLevelSelectionWindow(){
		Pane selectionWindow = new VBox();
		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Selection"));
		selectionWindow.getChildren().add(tbb.getToolBar());
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		selectionWindow.getChildren().add(entityScroller);
		entityScroller.prefViewportHeightProperty().bind(selectionWindow.heightProperty());
		
		return selectionWindow;
	}
	
	private Pane buildLevelProgressionWindow(){
		Pane progressionWindow = new VBox();
		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Progression"));
		progressionWindow.getChildren().add(tbb.getToolBar());
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		progressionWindow.getChildren().add(entityScroller);
		entityScroller.prefViewportWidthProperty().bind(progressionWindow.widthProperty());
		
		return progressionWindow;
	}
	
	public Pane getPane(){
		return myPane;
	}
	
	@Override
	public String toString(){
		return "Level Editor";
	}
	
}
