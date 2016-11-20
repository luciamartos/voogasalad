package gameplayer.application_scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorAlert {

	public void show(Exception e){
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(e.getMessage());
        a.setResizable(true);
        a.showAndWait();
	}
}
