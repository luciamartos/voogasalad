package label;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class LabelFactory {

	public Node createLabel(String aMessage, double aXPos, double aYPos) {
		Label label = new Label(aMessage);
		label.setTranslateX(aXPos);
		label.setTranslateY(aYPos);
		return label;
	}
	
	
}
