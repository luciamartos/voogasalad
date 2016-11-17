package gameplayer.animation_loop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class AnimationLoop {
	private static final int FRAMES_PER_SECOND = 1;
    private static final int MILLISECOND_DELAY = 1000/FRAMES_PER_SECOND;
    
	private Timeline animation;
	/**
	 * Constructor that takes in metadata and the grid 
	 * @param meta - the MetaData object
	 * @param grid - the grid
	 */
	public AnimationLoop() {
		this.animation = new Timeline();
	}
	
	
	public void init() {
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step());
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}

	private void step() {
	}

}
