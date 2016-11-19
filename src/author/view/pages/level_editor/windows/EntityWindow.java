package author.view.pages.level_editor.windows;

import author.controller.IAuthorController;
import author.view.util.ToolBarBuilder;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.TilePane;
import game_data.Level;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * This window contains all of the preset sprites. A user will drag and drop sprites from this window
 * onto the LevelWindow
 * @author Jordan Frazier, Cleveland Thompson
 * @see LevelWindow
 * @see ../LevelEditor
 */
public class EntityWindow extends AbstractLevelEditorWindow {
		
	private ScrollPane entityScroller;
	private TilePane container;
	
	private VBox entityList = new VBox();
	public EntityWindow(IAuthorController authorController, Level aLevel) {
		super(authorController, aLevel);
		addChildren(createScroller());
	}
	
	@Override
	public <T extends Node> void addChildren(T... child) {
		for (T node : child) {
			container.getChildren().add(node);
		}
	}

	@Override
	protected void createToolBar() {	
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Entity Selector"));
		addChildren(tbb.getToolBar());
	}
	
	private ScrollPane createScroller(){
		this.entityScroller = new ScrollPane();
		entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		entityScroller.setFitToHeight(true);
		entityScroller.setFitToWidth(true);
		entityScroller.prefHeightProperty().bind(super.getWindow().heightProperty());
		entityScroller.prefWidthProperty().bind(super.getWindow().widthProperty());
		entityScroller.setContent(this.entityList);
		return entityScroller;
	}

	/* (non-Javadoc)
	 * @see author.view.pages.level_editor.windows.AbstractLevelEditorWindow#initListener(author.controller.IAuthorController, game_data.Level)
	 */
	@Override
	protected void initListener(IAuthorController authorController, Level aLevel) {
		authorController.getModel().getGame().addListener((game) -> {
			this.entityList.getChildren().clear();
			authorController.getModel().getGame().getPresets().forEach((sprite) -> {
				Image image = new Image(sprite.getMyImagePath(), 50, 50, true, false);
				this.entityList.getChildren().add(new ImageView(image));
			});
		});
	}
}
