package gameplayer.gui_generator.button_generator;

import gameplayer.gui_generator.IGUIGenerator.ButtonDisplay;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonFactory {
	
	public Button buildButton(String aMessage, int aXPos, int aYPos, EventHandler<? super MouseEvent> aHandler, ButtonDisplay aDisplayType) {
		if (aDisplayType.equals(ButtonDisplay.CSS)) {
			return new CSSButton().createButton(aMessage, aXPos, aYPos, aHandler);
		}
		else if (aDisplayType.equals(ButtonDisplay.TEXT)) {
			return new TextButton().createButton(aMessage, aXPos, aYPos, aHandler);
		}
		return null;
	}

}
