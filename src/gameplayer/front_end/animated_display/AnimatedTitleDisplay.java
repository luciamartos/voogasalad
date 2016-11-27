package gameplayer.front_end.animated_display;

import gameplayer.front_end.gui_generator.GUIGenerator;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class AnimatedTitleDisplay {
	
	public Node buildAnimatedTitleDisplay() {
		GUIGenerator guiCreator = new GUIGenerator();
		HBox box = new HBox();
		box.getChildren().add(guiCreator.createLabel("Let's Just ", 0, 0));
		box.getChildren().add(guiCreator.createLabel("Pray ", 0,0));
		box.getChildren().add(guiCreator.createLabel("It ", 0, 0));
		box.getChildren().add(guiCreator.createLabel("Works",0,0));
		return box;
	}
	
	private Node makeFadeTransition(Node aObject) {
		FadeTransition fadeTransition = 
	            new FadeTransition(Duration.millis(1000), aObject);
	    fadeTransition.setFromValue(0f);
	    fadeTransition.setToValue(1.0f);
	    fadeTransition.setCycleCount(1);
	    //fadeTransition.setAutoReverse(false);
	    //fadeTransition.setAutoReverse(true);
	    fadeTransition.play();
		return aObject;
	}

}
