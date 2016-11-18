package gameplayer.button;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public interface IButton {
	
	public Node createButton(String aMessage, int aXPos, int aYPos);
	
	public Node createButton(ImageView aImage, int aXPos, int aYPos);
	
	public void setOnClick(EventHandler<? super MouseEvent> aHandler);
	
}
