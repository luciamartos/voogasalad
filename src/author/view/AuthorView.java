package author.view;

import author.view.utility.TabPaneFacade;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * AuthorView handles the JavaFX GUI.
 * 
 * @author George Bernard
 */
public class AuthorView {

	Scene myScene;
	Pane myLayout;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 450;
	
	public AuthorView(){
		myLayout = new VBox();
		myScene = new Scene(myLayout, WIDTH, HEIGHT, Color.WHITE);
		
		myLayout.getChildren().addAll(buildToolBar(), buildTabPane());
	}

	private ToolBar buildToolBar(){
		ToolBar toolbar = new ToolBar();
		
		final Pane filler = new Pane();
        HBox.setHgrow(
                filler,
                Priority.SOMETIMES
        );
		
		toolbar.prefWidthProperty().bind(myScene.widthProperty());
		toolbar.getItems().addAll(
				new Separator(),
				new Button("New"),
				new Button("Save"),
				new Button("Load"),
				new Separator(),
				filler,
				new Separator(),
				new Button("Save and Close"),
				new Separator()
				);
		
		return toolbar;
	}

	private TabPane buildTabPane(){
		TabPaneFacade tabpaneFacade = new TabPaneFacade();
		
		String[] names = new String[]{"Level Editor", "Entity Editor"};
		
		for (int i = 0; i < names.length; i++) {
            tabpaneFacade.addTab(names[i], null);
        }
		
		tabpaneFacade.getTabPane().prefWidthProperty().bind(myScene.widthProperty());
		tabpaneFacade.getTabPane().prefHeightProperty().bind(myScene.heightProperty());
		tabpaneFacade.getTabPane().setSide(Side.BOTTOM);
		
		return tabpaneFacade.getTabPane();
	}
	
	public Scene getScene(){
		return myScene;
	}
	
	
}
