package gameplayer.front_end.animated_display;

import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
//import javafx.animation.Transition;
import javafx.scene.Node;

public class AnimatedDisplayFactory {
	
	public Node buildAnimatedDisplayFactory() {
		return null;
	}
	
	
	public void init() {
		SequentialTransition sequentialTransition = new SequentialTransition();
		sequentialTransition.getChildren().addAll();
		        //fadeTransition,
		        //translateTransition,
		        //rotateTransition,
		        //scaleTransition);
		sequentialTransition.setCycleCount(Timeline.INDEFINITE);
		sequentialTransition.setAutoReverse(true);

		sequentialTransition.play();
	}
	
	

}
