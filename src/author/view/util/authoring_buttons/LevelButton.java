package author.view.util.authoring_buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
/**
 * A way to add functionality to a button through lambda
 * @author Jordan Frazier
 *
 */
public class LevelButton {

	private Button myButton;

	public LevelButton(String name, EventHandler<ActionEvent> e) {
		myButton = new Button(name);
		myButton.setOnAction(e);
	}

	public Button getButton() {
		return myButton;
	}

}
