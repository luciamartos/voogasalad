package author.view.pages.level_editor.windows;

import author.controller.IAuthorController;
import author.view.util.ToolBarBuilder;
import game_data.Level;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * This window will allow a user to see the progression of their levels. 
 * (@george so this window will need to automatically update when a user changes the 'end level' condition
 * on a level?)
 * @author Jordan Frazier
 * @see ../LevelEditor
 *
 */
public class LevelProgressionWindow extends AbstractLevelEditorWindow {

	public LevelProgressionWindow(IAuthorController authorController, Level aLevel) {
		super(authorController, aLevel);
	}

	@Override
	protected void createToolBar() {		
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Progression"));
		
		ScrollPane entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.prefViewportWidthProperty().bind(super.getWindow().widthProperty());
		
		addChildren(tbb.getToolBar());
		addChildren(entityScroller);
	}

	/* (non-Javadoc)
	 * @see author.view.pages.level_editor.windows.AbstractLevelEditorWindow#initListener(author.controller.IAuthorController, game_data.Level)
	 */
	@Override
	protected void initListener(IAuthorController authorController, Level aLevel) {
		// TODO Auto-generated method stub
		
	}

}
