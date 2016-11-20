package gameplayer.user_information;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import game_data.XMLSaver;

public class UserInformation implements IViewableUserInformation {
	
	private String myCurrentUser;
	private String myCurrentPassword;
	private Map<String, String> myUserInformation;
	private XMLSaver myXMLSaver;
	
	public UserInformation() {
		//deserializeTheXmlAndMakeMap();
		myUserInformation = new HashMap<String, String>();
		myXMLSaver = new XMLSaver();
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
		myXMLSaver.serialize(myUserInformation);
		
	}
	
	public Collection<String> getUserNames() {
		return myUserInformation.keySet();
	}
	
	public String getPassword(String aUserName) {
		return myUserInformation.get(aUserName);
	}



}
