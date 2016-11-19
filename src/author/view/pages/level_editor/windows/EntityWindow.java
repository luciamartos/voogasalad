package author.view.pages.level_editor.windows;

import author.controller.IAuthorController;
import author.view.util.ToolBarBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
	
	private VBox container = new VBox();
	public EntityWindow(IAuthorController authorController) {
		super(authorController);
		addChildren(createScroller());
	}

	@Override
	protected void createToolBar() {	
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Entity Selector"));
		addChildren(tbb.getToolBar());
	}
	
	private ScrollPane createScroller(){
		this.entityScroller = new ScrollPane();
		this.entityScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		this.entityScroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.entityScroller.setFitToHeight(true);
		this.entityScroller.setFitToWidth(true);
		this.entityScroller.prefHeightProperty().bind(super.getWindow().heightProperty());
		this.entityScroller.prefWidthProperty().bind(super.getWindow().widthProperty());
		this.entityScroller.setContent(this.container);
		return entityScroller;
	}

	/* (non-Javadoc)
	 * @see author.view.pages.level_editor.windows.AbstractLevelEditorWindow#initListener(author.controller.IAuthorController, game_data.Level)
	 */
	@Override
	protected void initListener(IAuthorController authorController) {
		authorController.getModel().getGame().addListener((game) -> {
			this.container.getChildren().clear();
			authorController.getModel().getGame().getPresets().forEach((sprite) -> {
				this.container.getChildren().add(getImageView(sprite.getMyImagePath(), 50.0, 50.0));
			});
		});
	}
}
