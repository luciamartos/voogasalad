package gameplayer.application_scene;

import gameplayer.user_information.IViewableUserInformation;
import gameplayer.user_information.UserInformationController;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Login Scene Initiation
 *
 * @author tedmarchildon, hannah
 *
 */
public class LoginScene extends AbstractPlayerScene {

	private VBox myOptions;
	private HBox myLoginOptions;
	private TextField myUserName;
	private TextField myPassword;
	private IViewableUserInformation myUserInformation;
	
	public LoginScene(double aWidth, double aHeight) {
		super(aWidth, aHeight);
		myUserInformation = new UserInformationController();
	}
	
	@Override
	public void addButton(String text, EventHandler<? super MouseEvent> handler){
		myLoginOptions.getChildren().add(myGUIGenerator.createButton(text, 0, 0, handler));
	}

	@Override
	public Scene init() {
		myRoot.setCenter(addNodes());
		return myScene;
	}
	
	private VBox addNodes() {
		myOptions = new VBox(BOX_INSETS);
		myLoginOptions = new HBox(BOX_INSETS);
		myUserName = myGUIGenerator.createTextField("Enter Username", 0, 0, 500);
		myPassword = myGUIGenerator.createTextField("Enter Password", 0, 0, 500);
		myOptions.getChildren().add(myUserName);
		myOptions.getChildren().add(myPassword);
		myLoginOptions.setAlignment(Pos.CENTER);
		myOptions.getChildren().add(myLoginOptions);
		myOptions.setAlignment(Pos.CENTER);
		return myOptions;
	}
	
	public void checkSignInValidity() {
		myUserInformation.isValid(myUserName.getText(), myPassword.getText());
	}
	
	public void signUpNewUser() {
		myUserInformation.saveToXML(myUserName.getText(), myPassword.getText());
	}

	@Override
	public void addNavigationButton(String aText, EventHandler<? super MouseEvent> aHandler) {
		//do nothing
	}

}
