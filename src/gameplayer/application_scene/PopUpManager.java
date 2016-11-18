package gameplayer.application_scene;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopUpManager implements IPopUpDisplay {

	private final int SIZE = 500;
	private Stage myStage;
	private VBox myOptions;
	
	public PopUpManager(){
		myStage = new Stage();
		myOptions = new VBox(40);
		myOptions.setAlignment(Pos.CENTER);
		Scene stageScene = new Scene(myOptions, SIZE, SIZE);
		myStage.setScene(stageScene);
	}
	
	public void addOption(Node node){
		myOptions.getChildren().add(node);
	}
	
	public void show(){
		myStage.show();
	}
}
