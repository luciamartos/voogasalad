package author.view.pages.level_editor.windows;

import java.io.File;

import author.view.util.FileLoader;
import author.view.util.FileLoader.FileType;
import author.controller.IAuthorController;
import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import game_data.Level;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 * This window is the actual level editor, where sprites will be placed from the
 * EntityWindow
 * 
 * @author Jordan Frazier
 * @see EntityWindow
 * @see ../LevelEditor
 */
public class LevelWindow extends AbstractLevelEditorWindow {

	private ScrollPane myLevelScroller;
	private Pane myContainer;

		
	public LevelWindow(IAuthorController authorController, Level aLevel) {
		super(authorController, aLevel);
		createLevelScroller();
	}

	@Override
	public <T extends Node> void addChildren(T... child) {
		for (T node : child) {
			myContainer.getChildren().add(node);
		}
	}

	@Override
	protected void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new ButtonFactory().createButton("Set Background", e -> {
			setBackgroundImage();
			System.out.println("Change background here");
		}).getButton(), new ButtonFactory().createButton("Set Theme", e -> {
			// TODO: Jordan - Add functionality to changing theme, what the
			// fucks a theme
			System.out.println("Change theme here");
		}).getButton());

		super.getWindow().getChildren().add(tbb.getToolBar());
	}

	private void createLevelScroller(){
		myLevelScroller = new ScrollPane();
		myContainer = new Pane();
		
		myLevelScroller.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myLevelScroller.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myLevelScroller.prefViewportHeightProperty().bind(super.getWindow().heightProperty());
		myLevelScroller.setContent(myContainer);
		
		super.getWindow().getChildren().add(myLevelScroller);

	}
	
	private void setBackgroundImage() {
		File file = new FileLoader(
				FileType.GIF, 
				FileType.JPEG, 
				FileType.PNG,
				FileType.JPG ).loadImage();
		
		System.out.println(file.toURI().toString());
		
		Image image = new Image( file.toURI().toString() );
		BackgroundImage backIm = new BackgroundImage(
				image, 
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, 
				new BackgroundSize(image.getWidth(), image.getHeight(), false, false, false, false));
		
		myContainer.setBackground(new Background(backIm));
		myContainer.setMinSize(image.getWidth(), image.getHeight());
	}

	/* (non-Javadoc)
	 * @see author.view.pages.level_editor.windows.AbstractLevelEditorWindow#initListener(author.controller.IAuthorController, game_data.Level)
	 */
	@Override
	protected void initListener(IAuthorController authorController, Level aLevel) {
		// TODO Auto-generated method stub
		
	}

}
