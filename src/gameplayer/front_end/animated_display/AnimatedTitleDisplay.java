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
		return makeFadeTransition(guiCreator.createImage("data/gui/praying-for-the-six.png"));
	}
	
	private Node makeFadeTransition(Node aObject) {
		FadeTransition fadeTransition = 
	            new FadeTransition(Duration.millis(5000), aObject);
	    fadeTransition.setFromValue(0f);
	    fadeTransition.setToValue(1.0f);
	    fadeTransition.setCycleCount(1);
	    //fadeTransition.setAutoReverse(false);
	    //fadeTransition.setAutoReverse(true);
	    fadeTransition.play();
		return aObject;
	}

}
