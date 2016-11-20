package gameplayer.user_information;

public interface IViewableUserInformation {
	
	public void isValid(String aUsername, String aPassword);
	
	public void saveToXML(String aUsername, String aPassword);

}
