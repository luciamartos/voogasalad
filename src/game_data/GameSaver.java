package game_data;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Saves a Game using XStream serialization
 * 
 * @author Addison
 */
public class GameSaver {
	
	/**
	 * @param aGame
	 * @return String of XML representation of serialized Game
	 * @author Addison
	 */
	public String serialize(Game aGame){
	    XStream mySerializer = new XStream(new DomDriver());
		return mySerializer.toXML(aGame);
	}

}
