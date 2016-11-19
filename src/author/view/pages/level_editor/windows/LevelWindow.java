package author.view.pages.level_editor.windows;

import author.view.util.FileLoader;
import author.view.util.ToolBarBuilder;
import author.view.util.authoring_buttons.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Control;
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

	private ScrollPane levelScroller;
	private Pane container;

	public LevelWindow() {
		super.createWindow();
		createToolBar();
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
		tbb.addBurst(new Label("Level Window"));
		tbb.addFiller();
		tbb.addBurst(new ButtonFactory().createButton("Set Background", e -> {
			// TODO: Jordan(vooga): allow user to specify a background image
			setBackgroundImage();
			System.out.println("Change background here");
		}).getButton(), new ButtonFactory().createButton("Set Theme", e -> {
			// TODO: Jordan - Add functionality to changing theme, what the
			// fucks a theme
			System.out.println("Change theme here");
		}).getButton());

		container = new Pane();
		levelScroller = new ScrollPane();
		levelScroller.setFitToHeight(false);
		levelScroller.setFitToWidth(false);

		levelScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		levelScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		levelScroller.prefViewportHeightProperty().bind(super.getWindow().heightProperty());
		levelScroller.prefViewportWidthProperty().bind(super.getWindow().widthProperty());

		container.setPrefHeight(10000);
		container.setPrefWidth(10000);
//		container.setMinWidth(super.getWindow().heightProperty().doubleValue());
//		container.setMinHeight(super.getWindow().getHeight());
		
		levelScroller.setContent(container);

		super.getWindow().getChildren().add(tbb.getToolBar());
		super.getWindow().getChildren().add(levelScroller);
	}

	private void setBackgroundImage() {
		Image image = new Image("author/images/mario.jpg");
		BackgroundImage backIm = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, new BackgroundSize(levelScroller.getPrefViewportWidth(),
						levelScroller.getPrefViewportHeight(), false, false, false, false));
		container.setBackground(new Background(backIm));
	}

}
