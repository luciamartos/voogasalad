package gameplayer.application_scene;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public abstract class AbstractNavigationPlayerScene extends AbstractPlayerScene {
	
	public AbstractNavigationPlayerScene(double aWidth, double aHeight) {
		super(aWidth, aHeight);
		addNavigation();
	}
	
	public void addNavigationButton(String aText, EventHandler<? super MouseEvent> aHandler) {
		myNavigation.getChildren().add(createButton(aText, 0, 0, aHandler));
	}
	
	private void addNavigation() {
		myNavigation = new HBox(BOX_INSETS);
		myNavigation.setAlignment(Pos.CENTER_LEFT);
		myRoot.setTop(myNavigation);
	}

}
