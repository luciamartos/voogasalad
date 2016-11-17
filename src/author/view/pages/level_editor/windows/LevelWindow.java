package author.view.pages.level_editor.windows;

import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * This window is the actual level editor, where sprites will be placed from the
 * EntityWindow
 * 
 * @author Jordan Frazier
 * @see EntityWindow
 * @see ../LevelEditor
 */
public class LevelWindow extends AbstractLevelEditorWindow {

	public LevelWindow() {
		super.createWindow();
		createToolBar();
	}

	@Override
	protected void createToolBar() {
		ToolBarBuilder tbb = new ToolBarBuilder();
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new ButtonFactory().createButton("Set Background", e -> {
			// TODO: Jordan(vooga): allow user to specify a background image
			setBackgroundImage();
			System.out.println("Change background here");
		}).getButton(), new ButtonFactory().createButton("Set Theme", e -> {
			// TODO: Jordan - Add functionality to changing theme, what the fucks a theme
			System.out.println("Change theme here");
		}).getButton());

		addChild(tbb.getToolBar());
	}

	private void setBackgroundImage() {
		Image image = new Image("author/images/mario.jpg");
		BackgroundImage backIm = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1, 1, true, true, false, false));
		super.getWindow().setBackground(new Background(backIm));
	}
	
}
