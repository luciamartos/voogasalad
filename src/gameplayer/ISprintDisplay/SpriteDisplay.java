package gameplayer.ISprintDisplay;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public class SpriteDisplay {

	public Node buildISpriteDisplay(String aFileName) {
		return new ImageView(aFileName);
	}

	public Node buildISpriteDisplay(Shape aShape) {
		return null;
	}
	
}
