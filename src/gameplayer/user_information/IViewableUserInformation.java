package gameplayer.user_information;

public interface IViewableUserInformation {
	
	public void signIn(String aUsername, String aPassword) throws Exception;
	
	public void signUp(String aUsername, String aPassword) throws Exception;

}
