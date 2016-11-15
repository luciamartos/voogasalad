package author.main;

import author.view.AuthorView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage aStage) throws Exception {
		AuthorView authorView = new AuthorView();
		aStage.setTitle("VOOGASalad");
		
		Scene scene = authorView.getScene();
		aStage.setResizable(false);
		aStage.setScene(scene);
		aStage.show();
	}

	public static void main(String[] args){
		Application.launch(args);
	}
}
