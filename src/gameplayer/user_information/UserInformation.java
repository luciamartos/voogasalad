package gameplayer.user_information;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

public class UserInformation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> myInformation; 

	public UserInformation(XStream aSerializer) {
		UserInformation information = (UserInformation) aSerializer.fromXML("");
		//init(information.map);
	}
	
	private void init(Map<String, String> aMap) {
		myInformation = aMap;
	}
	
	public Collection<String> getUserNames() {
		return myInformation.keySet();
	}
	
	public String getPassword(String aUserName) {
		return myInformation.get(aUserName);
	}

}
