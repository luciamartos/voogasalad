package gameplayer.front_end.animated_display;

import gameplayer.front_end.gui_generator.GUIGenerator;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class AnimatedDisplay {
	

	public Node makeFadeTransition(Node aObject) {
		FadeTransition fadeTransition = 
	            new FadeTransition(Duration.millis(10000), aObject);
	    fadeTransition.setFromValue(0f);
	    fadeTransition.setToValue(1.0f);
	    fadeTransition.setCycleCount(1);
	    //fadeTransition.setAutoReverse(false);
	    //fadeTransition.setAutoReverse(true);
	    fadeTransition.play();
		return aObject;
	}

}
