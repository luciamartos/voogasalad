package author.view.utility;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;

/**
 * Simple Facade for adding new tabs to TabPane. 
 * If Greater functionality required then use getTabPane().
 * 
 * @see TabPane
 * @author George Bernard
 */
public class TabPaneFacade {
	
	private TabPane myTabPane;
	
	/**
	 * Constructs Object
	 */
	public TabPaneFacade(){
		myTabPane = new TabPane();
	}
	
	/**
	 * Adds tab page to TabPane. 
	 * 
	 * @param aName is the tab text
	 * @param aContent is the page content
	 */
	public void addTab(String aName, Node aContent){
		Tab tab = new Tab();
		tab.setText(aName);
		tab.setClosable(false);
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label(aName));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);
        myTabPane.getTabs().add(tab);
	}

	/**
	 * Returns internal tabpane if greater functionality is required.
	 * 
	 * @return TabPane
	 */
	public TabPane getTabPane(){
		return myTabPane;
	}
	
}
