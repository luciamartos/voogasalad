package gameplayer.front_end.animated_display;

import gameplayer.front_end.gui_generator.GUIGenerator;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class AnimatedTitleDisplay {
	
	private HBox myBox;
	
	public AnimatedTitleDisplay() {
		myBox = new HBox();
	}
	
	public HBox buildAnimatedTitleDisplay() {
		GUIGenerator guiCreator = new GUIGenerator();
		//box.setPadding(new Insets(0,0,0,0));
		myBox.getChildren().add(makeFadeTransition(guiCreator.createImage("data/gui/praying-for-the-six.png", 70)));
		myBox.getChildren().add(guiCreator.createImage("data/gui/it_works.png", 300));
		return myBox;
	}
 	
	private Node makeFadeTransition(Node aObject) {
		FadeTransition fadeTransition = 
	            new FadeTransition(Duration.millis(2000), aObject);
	    fadeTransition.setFromValue(0f);
	    fadeTransition.setToValue(1.0f);
	    fadeTransition.setCycleCount(1);
	    //fadeTransition.setAutoReverse(false);
	    //fadeTransition.setAutoReverse(true);
	    fadeTransition.play();
		return aObject;
	}

}
