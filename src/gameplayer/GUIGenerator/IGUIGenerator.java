package gameplayer.GUIGenerator;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public interface IGUIGenerator {
		
	public Button createButton(String amessage, int x, int y, EventHandler<? super MouseEvent> ahandler);
		
	public TextField createTextField(String aplaceholder, int x, int y, int width);
		
	public Label createLabel(String atext, int x, int y);

	public void setBackground(Pane avalue, String afilepath);
		
	public void setBackground(Pane avalue, Paint fill);

	
}
