package gameplayer.user_information;

import java.util.Map;

public class UserInformationController implements IViewableUserInformation {
	
	private String myCurrentUser;
	private String myCurrentPassword;
	private Map<String, String> myUserInformation;
	
	public UserInformationController() {
		//deserializeTheXmlAndMakeMap();
		//myUserInformation = new UserInformation(XStream); 
	}
	
	public void isValid(String aUserName, String aPassword) {
		//if (!myUserInformation.getUserNames().contains(myCurrentUser)) {
			//throw new UserIDException("XYZ is not a valid username");
		//} else {
		// myCurrentUser = aUserName;
		// myCurrentPassword = aPassword;
	//}
	}
	
	public void saveToXML(String aUserName, String aPassword) {
		//isValid("XYZ already exists");
		//save to XML
	}



}
