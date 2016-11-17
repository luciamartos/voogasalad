package gameplayer.application_scene;

import javafx.stage.Stage;

public class ApplicationScene {
	
	private Stage myStage;
	private SceneFactory mySceneBuilder;
	
	public ApplicationScene(Stage aStage) {
		this.myStage = aStage;
	}
	
	public void createScene(SceneIdentifier aScene) { 
		myStage.close(); 
		IDisplay menu = mySceneBuilder.create(aScene);
		myStage.setScene(menu.init());
		myStage.show();
	}
	
	
}
