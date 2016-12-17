package gameplayer.application_controller;

import gameplayer.back_end.exceptions.VoogaFacebookException;
import gameplayer.back_end.facebook.FacebookInformation;
import gameplayer.back_end.user_information.UserInformation;

public class PlayerInformationController {
	
	private UserInformation myUserInformation; 
	private FacebookInformation myFacebookInformation;
	
	public PlayerInformationController() {
		myUserInformation = new UserInformation();
		myFacebookInformation = new FacebookInformation();
	}
	
	public double getHighScores(String aUserName) {
		//return myHighScores.getHighScore(aUserName);
		return 0;
	}
	
	public void setUserName(String aUserName, String aPictureUrl) {
		myUserInformation = new UserInformation(aUserName, aPictureUrl);
	}
	
	public String getUser() {
		return myUserInformation.getUserName();
	}
	
	public void facebookLogin() {
		myFacebookInformation.authenticatePlayer();
		myUserInformation = new UserInformation(myFacebookInformation.getUserName(), myFacebookInformation.getProfilePicture());
		//myUserInformation.setUserImage(myFacebookInformation.getProfilePicture());
	}

	public String getPictureUrl() {
		return myUserInformation.getPictureUrl();
	}

	public void publishToFaceBook(String aTitle, String aMessage) throws VoogaFacebookException {
		myFacebookInformation.publishNews(aTitle, aMessage);
	}
}
