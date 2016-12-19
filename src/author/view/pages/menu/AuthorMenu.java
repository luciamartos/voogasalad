// This entire file is part of my masterpiece.
// Addison Howenstine

/*
 * This class is a good example of somewhere I implemented ILanguageUser
 * to add language changing capability. AuthorMenu is a class that was started before
 * I joined the authoring environment sub-team but had to work with a lot from the
 * beginning. I had never worked on front end before shifting to authoring environment
 * for this project after initially setting up and finishing game data. I worked a lot on
 * adding to and refactoring this class to be cleaner throughout the project and 
 * now while working on my masterpiece, and I think it shows how I was able
 * to join the subteam and effectively learn their style and how to further their code. I
 * implemented the Observer / Observable pattern here such that when the language in use
 * is changed, this class will be notified and will reset the text in the top menu. I am
 * proud of code I wrote in other parts of the project and for large scale design decisions I made
 * elsewhere (as discussed in detail in my analysis), but for me one of the biggest learning
 * experiences working on VOOGASalad was needing to read and modify *other* people's code,
 * and I think this class is a great representation of how I was able to do just that. I'm
 * also very excited to have gotten language changing to work in my masterpiece.
 */

package author.view.pages.menu;

import java.io.File;
import java.io.FileNotFoundException;
import author.controller.IAuthorController;
import author.model.IAuthorModel;
import author.view.pages.level_editor.ILevelEditorExternal;
import author.view.util.game_info.GameInfoEditWindowFactory;
import author.view.util.game_info.iGameInfoEditWindow;
import author.view.util.language_selection.ILanguageHolder;
import author.view.util.language_selection.ILanguageUser;
import game_data.Level;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextInputDialog;
import util.filehelpers.FileLoader.FileLoader;
import util.filehelpers.FileLoader.FileType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 * Holds and initializes the top menu bar of the Authoring Environment
 * which includes the   | File | Edit | Help |   bars
 * 
 * @author Addison Howenstine
 */
public class AuthorMenu implements ILanguageUser{

	private HBox myContainer;
	private MenuBar myMenu;
	private IAuthorModel myAuthorModel;
	private ILanguageHolder myLanguageHolder;
	private ILevelEditorExternal myLevelEditor;


	public AuthorMenu(IAuthorController aAuthorController, ILevelEditorExternal aLevelEditor) {
		myAuthorModel = aAuthorController.getModel();
		myLanguageHolder = aAuthorController;
		myLanguageHolder.addListener(this);
		myLevelEditor = aLevelEditor;
		myContainer = new HBox();
		buildMenu();
	}
	
	/**
	 * If the Author Menu is notified that it's LanguageHolder has been
	 * declared invalidated, it will update all of the text stored in the menu
	 * bar by rebuilding the menu with text in the new language.
	 */
	@Override
	public void invalidated(Observable arg0) {
		buildMenu();
	}

	private void buildMenu() {
		myMenu = new MenuBar();
		Menu menuFile = new Menu(myLanguageHolder.getDisplayText("File"));
		Menu menuEdit = new Menu(myLanguageHolder.getDisplayText("Edit"));
		Menu menuHelp = new Menu(myLanguageHolder.getDisplayText("Help"));
		myMenu.getMenus().addAll(menuFile, menuEdit, menuHelp);

		addFileMenuItems(menuFile);
		addEditMenuItems(menuEdit);
		addHelpMenuItems(menuHelp);

		myContainer.getChildren().clear();
		myContainer.getChildren().add(myMenu);
		addFiller();
		addGameTitle();
	}
	
	public HBox getContainer() {
		return myContainer;
	}
	
	/**
	 * Adds a sub-menu button when given a key String to
	 * use as a language lookup in a properties file
	 * 
	 * @param aMenu - menu option to add to
	 * @param aDisplayTextKey - key to search for in properties file as display text
	 * @param e - event to execute on click
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addMenuItem(Menu aMenu, String aDisplayTextKey, EventHandler e) {
		aMenu.getItems().add(new MenuFactory().createItem(myLanguageHolder.getDisplayText(aDisplayTextKey), e).getItem());
	}
	
	private void addFileMenuItems(Menu menuFile) {
		
		addMenuItem(menuFile, "NewGame", e -> {
			this.myAuthorModel.newGameWindow();
		});
		
		addMenuItem(menuFile, "NewLevel", e -> {
			Level createdLevel = this.myLevelEditor.createLevel();
			if (createdLevel != null) {
				this.myAuthorModel.getGame().addNewLevel(createdLevel);
			}
		});
		
		addMenuItem(menuFile, "SaveGame", e -> {
			openSaveDialog();
		});
		
		addMenuItem(menuFile, "LoadGame", e -> {
			File aFile = loadFileChooser();
			if (aFile != null)
				myAuthorModel.loadGame(aFile);
		});
		
		addMenuItem(menuFile, "NewGame", e -> {
			this.myAuthorModel.newGameWindow();
		});
	}
	
	private void addEditMenuItems(Menu menuEdit) {
		
		addMenuItem(menuEdit, "EditGame", e -> {
			iGameInfoEditWindow infoEditor = new GameInfoEditWindowFactory().create(myAuthorModel.getGame(), myLanguageHolder);
			infoEditor.display();
		});
		
		addMenuItem(menuEdit, "AuthorInEnglish", e -> {
			myLanguageHolder.setLanguage("English");
		});
		
		addMenuItem(menuEdit, "AuthorInSpanish", e -> {
			myLanguageHolder.setLanguage("Spanish");
		});
	}
	
	private void addHelpMenuItems(Menu menuLoad) {
		addMenuItem(menuLoad, "Help", e -> {
			openHelpDialog();
		});
	}

	private void addGameTitle() {
		Label gameTitle = new GameNameDisplay(myAuthorModel.getGame());
		myContainer.getChildren().add(gameTitle);
	}

	private void openSaveDialog() {
		TextInputDialog input = new TextInputDialog(myAuthorModel.getGame().getName());
		input.setTitle(myLanguageHolder.getDisplayText("SaveDialog"));
		input.setHeaderText(myLanguageHolder.getDisplayText("InputGameName"));
		input.setContentText(myLanguageHolder.getDisplayText("Name"));
		input.setOnCloseRequest(e -> {
			myAuthorModel.saveGame(input.getResult());
		});
		input.showAndWait();
	}

	private File loadFileChooser() {
		File file;
		try { file = new FileLoader(myLanguageHolder.getPathString("XMLGameFiles"), FileType.DATA).loadSingle();
			return file;
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	private void openHelpDialog() {
		HelpDialog helpDialog = new HelpDialog();
		helpDialog.display();
	}
	
	private void addFiller(){
		final Pane filler = new Pane();
		HBox.setHgrow(filler, Priority.SOMETIMES);  
		myContainer.getChildren().add(filler);
	}
}