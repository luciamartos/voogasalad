package gameplayer.front_end.application_scene;

import java.text.DecimalFormat;

import game_data.Game;
import gameplayer.back_end.resources.FrontEndResources;
import gameplayer.back_end.user_information.HighscoreManager;
import gameplayer.front_end.gui_generator.GUIGenerator;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class UserProfileScene extends AbstractNavigationPlayerScene {

	private GUIGenerator myGUIGenerator; 
	private String myUserName;
	private String myPictureUrl = "gui/blank_profile_page.jpeg";
	private double myWidth;
	private StackPane myPane;

	public UserProfileScene(String aName, String aUrl, double aWidth, double aHeight, HighscoreManager aManager) {
		super(aWidth, aHeight);
		myGUIGenerator = new GUIGenerator();
		myUserName = aName;
		myWidth = aWidth;
		myPane = new StackPane();
		myPane.setId("glass");
		addScores(aManager);
		if (aUrl != null) myPictureUrl = aUrl;
	}

	@Override
	public Scene init() {
		//getRoot().setCenter(addNodes());
		addTop();
		getRoot().setCenter(myPane);
		return myScene;
	}

	private void addTop() {
		HBox hbox = new HBox(FrontEndResources.BOX_INSETS.getDoubleResource()); 
		hbox.setOpacity(1);
		ImageView profilePicture = new ImageView(new Image(myPictureUrl));
		profilePicture.setFitWidth(myWidth * .1);
		profilePicture.setPreserveRatio(true);
		//profilePicture.setFitHeight(myHeight * .1);
		hbox.getChildren().add(profilePicture);
		Label userName = myGUIGenerator.createLabel(myUserName, 0, 0);
		//userName.setId("heading");
		hbox.getChildren().add(userName);
		hbox.setAlignment(Pos.TOP_LEFT);
		myPane.getChildren().add(hbox);
	}
	
	private void addScores(HighscoreManager aManager) {
		HBox box = new HBox(50);
		VBox games = new VBox();
		VBox scores = new VBox();
		for (int i = 0; i < aManager.getUsers().size(); i++) {
			if (aManager.getUsers().get(i).equals(myUserName)) {
				addInfo(aManager.getGames().get(i), aManager.getHighscores().get(i), games, scores);
			}
		}
		box.getChildren().add(games);
		box.getChildren().add(scores);
		box.setAlignment(Pos.CENTER_RIGHT);
		myPane.getChildren().add(box);
	}
	
	private void addInfo(Game aGame, double aScore, VBox aGames, VBox aScores) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		Double d = Double.valueOf(twoDForm.format(aScore));
		aGames.getChildren().add(getGUIGenerator().createLabel(aGame.getName(), 0, 0));
		aScores.getChildren().add(getGUIGenerator().createLabel(String.valueOf(d), 0, 0));
	}
}
