package gameplayer.application_controller;

import gameplayer.game_display_information.GameDisplayInformation;
import gameplayer.game_display_information.IViewableGameDisplayInformation;
import gameplayer.user_information.IViewableUserInformation;
import gameplayer.user_information.UserInformationController;

public class PlayerInformationController {
	
	private IViewableUserInformation myUserInformation; 
	private IViewableGameDisplayInformation myGameDisplayInformation;
	
	public PlayerInformationController() {
		myUserInformation = (IViewableUserInformation) new UserInformationController();
		myGameDisplayInformation = (IViewableGameDisplayInformation) new GameDisplayInformation();
		myGameDisplayInformation = new GameDisplayInformation();
	}
	
	public void userSignIn(String aUsername, String aPassword) throws Exception{
		try {
			myUserInformation.signIn(aUsername, aPassword);
		} catch (Exception e) {
			throw e;
		}
	}

	public void userSignUp(String aUsername, String aPassword) throws Exception {
		try {
			myUserInformation.signUp(aUsername, aPassword);
		} catch (Exception e) {
			throw e;
		}
	}
}
