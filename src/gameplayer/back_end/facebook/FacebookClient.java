package gameplayer.back_end.facebook;

import java.util.logging.LogManager;

import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;

public class FacebookClient {
	
	private static final String ACCESS_TOKEN = "EAACEdEose0cBAKqz91ZCys1MtLyDmwA5Urg1dTYiqpXc6EeAowOTnIAwAxfgZASsu77VhmJaof5vild7evkIjLrWE1ZBAc4j7ZAhGmS0BZASXZCPe93HnZBfmoEcq5py12e6dP54PhUwjNy54fhEncXaKhpp4izdMEaEpzheZAMJkQZDZD";

	DefaultFacebookClient facebookClient = new DefaultFacebookClient
			 (ACCESS_TOKEN);
	
	User user = facebookClient.fetchObject("me", User.class);
	
	//System.out.println(user);
	 
 }