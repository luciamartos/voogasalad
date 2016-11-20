package gameplayer.application_controller;

import gameplayer.game_display_information.GameDisplayInformation;
import gameplayer.game_display_information.IViewableGameDisplayInformation;
import gameplayer.user_information.IViewableUserInformation;
import gameplayer.user_information.UserInformation;

public class PlayerInformationController {
	
	private IViewableUserInformation myUserInformation; 
	private IViewableGameDisplayInformation myGameDisplayInformation;
	
	public PlayerInformationController() {
		myUserInformation = (IViewableUserInformation) new UserInformation();
		myGameDisplayInformation = (IViewableGameDisplayInformation) new GameDisplayInformation();
	}
	
	
	public void userSignIn(String aUsername, String aPassword){
		myUserInformation.isValid(aUsername, aPassword);
	}
	
	
	public void userSignUp(String aUsername, String aPassword) {
		myUserInformation.saveToXML(aUsername, aPassword);
	}

}
