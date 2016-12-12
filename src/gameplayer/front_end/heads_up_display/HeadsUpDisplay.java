package gameplayer.front_end.heads_up_display;

import gameplayer.front_end.gui_generator.GUIGenerator;
import gameplayer.front_end.gui_generator.IGUIGenerator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HeadsUpDisplay {

	private MenuBar myTopMenu;
	private IGUIGenerator myGUIGenerator;
	private BorderPane myRoot;
	private String myFontColor;
	private HBox myBottom;
	
	public HeadsUpDisplay(double aWidth, double aHeight, String aFontColor) {
		myGUIGenerator = new GUIGenerator();
		myRoot = new BorderPane();
		myFontColor = aFontColor;
	}

	public void addMenu(String aTitle, String[] aText, @SuppressWarnings("unchecked") EventHandler<ActionEvent>... aHandler) {
		myTopMenu.getMenus().add(myGUIGenerator.createMenu(aTitle, aText, aHandler));
	}

	public void addMenu(ImageView aImage, String[] aText, @SuppressWarnings("unchecked") EventHandler<ActionEvent> ... aHandler) {
		myTopMenu.getMenus().add(myGUIGenerator.createMenu(aImage, aText, aHandler));
	}

	private Node createTop() {
		myTopMenu = new MenuBar();
		//myTop.getChildren().add(myTopMenu);
		//myTopMenu.setAlignment(Pos.CENTER);
		return myTopMenu;
	}

	private Node createBottom() {
		myBottom = new HBox();
		myBottom.setAlignment(Pos.CENTER);
		return myBottom;
	}

	public Pane init() {
		myRoot.setBottom(createBottom());
		myRoot.setTop(createTop());
		myRoot.setBackground(Background.EMPTY);
		return myRoot;
	}

	public void addNode(Node aNode) {
		aNode.setId("animation-label");
		aNode.setStyle("-fx-text-fill: " + myFontColor.toLowerCase());
		myBottom.getChildren().add(aNode);
	}
	
	public void addNode(Node aNode, int aPos) {
		if (myBottom.getChildren().size() > 2) {
			myBottom.getChildren().remove(aPos);
			addNode(aNode);
		} else {
			addNode(aNode);
		}
	}
}
