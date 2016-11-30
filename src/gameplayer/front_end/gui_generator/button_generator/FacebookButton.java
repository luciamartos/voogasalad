package gameplayer.front_end.gui_generator.button_generator;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class FacebookButton extends AbstractButton {

	@Override
	public Button createButton(String aMessage, int aXPos, int aYPos, EventHandler<? super MouseEvent> aHandler) {
		Button button = super.createButton(aMessage, aXPos, aYPos, aHandler); 
		button.setId("facebook-button");
		button.setText(aMessage);
		return button;
	}

}
