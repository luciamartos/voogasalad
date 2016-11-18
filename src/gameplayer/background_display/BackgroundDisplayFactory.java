package gameplayer.background_display;

import java.io.FileNotFoundException;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class BackgroundDisplayFactory {
	
	public Node buildBackgroundDisplay(String aFileName) throws FileNotFoundException {
		return new ImageView(aFileName);
	}

}
