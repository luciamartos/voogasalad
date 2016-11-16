package gameplayer.button;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ButtonFactory {
	
	public Node createButton(String aMessage, int aXPos, int aYPos, EventHandler<? super MouseEvent> aHandler) {
		Button button = new Button(aMessage);
		createButtonHelper(button, aXPos, aYPos, aHandler);
		return button;
	}
	
	public Node createButton(ImageView aImage, int aXPos, int aYPos, EventHandler<? super MouseEvent> aHandler) {
		Button button = new Button("", (Node) aImage);
		createButtonHelper(button, aXPos, aYPos, aHandler);
		return button;
	}
	
	private void createButtonHelper(Button button, int aXPos, int aYPos, EventHandler<? super MouseEvent> aHandler) {
		button.setOnMouseClicked(aHandler);
		button.setTranslateX(aXPos);
		button.setTranslateY(aYPos);
	}

}
