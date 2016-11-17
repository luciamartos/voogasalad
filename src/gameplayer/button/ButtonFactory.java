package gameplayer.button;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ButtonFactory implements IButton {
	
	private Button myButton;
	
	public Node createButton(String aMessage, int aXPos, int aYPos) {
		this.myButton = new Button(aMessage);
		createButtonHelper(aXPos, aYPos);
		return myButton;
	}
	
	public Node createButton(ImageView aImage, int aXPos, int aYPos) {
		this.myButton = new Button("", (Node) aImage);
		createButtonHelper(aXPos, aYPos);
		return myButton;
	}
	
	private void createButtonHelper(int aXPos, int aYPos) {
		myButton.setTranslateX(aXPos);
		myButton.setTranslateY(aYPos);
	}

	@Override
	public void setOnClick(EventHandler<? super MouseEvent> aEvent) {
		myButton.setOnMouseClicked(aEvent);
	}

}
