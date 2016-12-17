package author.view;

import java.io.File;

import author.controller.IAuthorController;
import author.view.pages.level_editor.ILevelEditorExternal;
import author.view.pages.level_editor.LevelEditorFactory;
import author.view.pages.menu.AuthorMenu;
import author.view.pages.sprite.page.SpritesPage;
import author.view.util.language_selection.ILanguageUser;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import util.facades.TabPaneFacade;

/**
 * AuthorView handles the JavaFX GUI.
 * 
 * @author George Bernard, Cleveland Thompson, Addison Howenstine, Jordan
 *         Frazier
 */
public class AuthorView implements ILanguageUser{

	private Scene myScene;
	private Pane myPane = new VBox();
	private TabPaneFacade myTabPaneFacade;
	private IAuthorController myAuthorController;

	private boolean displayInformationDialog = true;
	private SpritesPage mySpritesPage;
	private ILevelEditorExternal myLevelEditor;

	// TODO move these to properties, as well as button names
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;

	public AuthorView(IAuthorController authorController) {
		myAuthorController = authorController;
		myScene = new Scene(myPane, WIDTH, HEIGHT, Color.WHITE);
		myScene.getStylesheets().add(getStyleSheet());
		initializeView();
		authorController.addListener(this);
	}

	private void initializeView() {
		this.mySpritesPage = new SpritesPage(myAuthorController);
		this.myLevelEditor = new LevelEditorFactory().create(this.myAuthorController);
		myPane.getChildren().addAll(buildMenu(), buildTabPane());
	}

	@Deprecated
	private void displayInformation() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (displayInformationDialog) {
					displayInformationalDialog();
					displayInformationDialog = false;
				}
			}
		});
	}

	public void reinitializeView() {
		this.myPane.getChildren().clear();
		initializeView();
	}

	/**
	 * Returns Toolbar built for primary AuthorScene
	 */

	private Node buildMenu() {
		AuthorMenu menu = new AuthorMenu(myAuthorController, myLevelEditor);
		return menu.getContainer();
	}

	/**
	 * Returns TabPane built for primary AuthorScene
	 */
	private Node buildTabPane() {
		myTabPaneFacade = new TabPaneFacade();
		myTabPaneFacade.getTabPane().prefWidthProperty().bind(myScene.widthProperty());
		myTabPaneFacade.getTabPane().prefHeightProperty().bind(myScene.heightProperty());
		myTabPaneFacade.getTabPane().setSide(Side.BOTTOM);

		myTabPaneFacade.addTab(mySpritesPage.toString(), mySpritesPage.getRegion());
		myTabPaneFacade.addTab(myLevelEditor.toString(), myLevelEditor.getPane());
		nameTabs();

		return myTabPaneFacade.getTabPane();
	}
	
	private void nameTabs() {
		myTabPaneFacade.getTabPane().getTabs().forEach(t -> {
			t.setText(myAuthorController.getDisplayText(t.getContent().getId()));
		});
	}

	private String getStyleSheet() {
		File css = new File(myAuthorController.getPathString("AuthorCSSStyle"));
		return css.toURI().toString();
	}

	private void displayInformationalDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("VoogaSalad Game");
		alert.setHeaderText("Welcome to your new game!");
		alert.setContentText(
				"To get started, select 'New', then 'New Level', to begin creating your game.\nFrom there, you can create Characters in the Sprite Editor, then drag and drop them onto your level in the Level Editor.\n ");
		alert.showAndWait();
	}

	public Scene getScene() {
		return myScene;
	}

	@Override
	public void invalidated(Observable arg0) {
		nameTabs();
	}

}
