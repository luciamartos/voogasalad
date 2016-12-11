

import gameplayer.application_controller.ApplicationController;
import gameplayer.back_end.resources.FrontEndResources;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ApplicationController appControl = new ApplicationController(primaryStage);
		appControl.displayMainMenu(FrontEndResources.SCENE_SIZE.getDoubleResource(), FrontEndResources.SCENE_SIZE.getDoubleResource());
	}
	
	public static void main(String[] args){
		launch(args);
	}
}