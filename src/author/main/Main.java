package author.main;

import author.model.game_observables.ObservableSprite;
import author.model.game_observables.ObservableSpriteFactory;
import author.view.AuthorView;
import game_data.Location;
import game_data.Player;
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
		//Application.launch(args);
		
		ObservableSprite sprite = new ObservableSpriteFactory().create(new Player(new Location(0, 0, 0), "ImagePath"));
		
		sprite.addListener((observable) -> {
			
		});
		
		sprite.setMyImagePath("NewImagePath");
	}
}
