package author.view.utility;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;

public class TabPaneFacade {
	
	private TabPane myTabPane;
	
	public TabPaneFacade(){
		myTabPane = new TabPane();
	}
	
	public void addTab(String aName, Node aContent){
		Tab tab = new Tab();
		tab.setText(aName);
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label(aName));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(hbox);
        myTabPane.getTabs().add(tab);
	}

	public TabPane getTabPane(){
		return myTabPane;
	}
	
	
	
}
