package gameplayer.application_scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene startScene = new LoginScene(primaryStage).init();
		primaryStage.setScene(startScene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
