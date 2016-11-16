package gameplayer.application_scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneFactory sceneBuilder = new SceneFactory();
		Scene startScene = sceneBuilder.create(primaryStage, SceneIdentifier.LOGIN).init();
		primaryStage.setScene(startScene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
