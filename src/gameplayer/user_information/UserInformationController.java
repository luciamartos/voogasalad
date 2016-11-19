package gameplayer.user_information;

import java.util.Map;

public class UserInformationController implements IViewableUserInformation {
	
	private String myCurrentUser;
	private String myCurrentPassword;
	private Map<String, String> myUserInformation;
	
	public UserInformationController(String aUserName, String aPassword) {
		//deserializeTheXmlAndMakeMap();
		myCurrentUser = aUserName;
		myCurrentPassword = aPassword;
		//myUserInformation = new UserInformation(XStream); 
	}
	
	public void isValid() {
		//if (!myUserInformation.getUserNames().contains(myCurrentUser)) {
			//throw new UserIDException("XYZ is not a valid username");
		//} 
	}
	
	public void saveToXML() {
		//isValid("XYZ already exists");
		//save to XML
	}


}
