package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Saves an Object using XStream serialization
 * 
 * @author Addison
 */
public class XMLTranslator {
	

	/**
	 * Can be used to serialize a Game, Level, Sprite, etc. as XML
	 * 
	 * @param o
	 * @return String of XML representation of serialized Object
	 * @author Addison
	 */
	public String serialize(Object o){
		XStream mySerializer = new XStream(new DomDriver());
		return mySerializer.toXML(o);
	}

	public File saveToFile(Object o, String aFilePath, String aFileName){
		File aFile = new File(aFilePath + aFileName + ".xml");
		return saveToFile(o, aFile);
	}

	public File saveToFile(Object o, File aFile){
		try {
			FileWriter fw = new FileWriter(aFile);
			fw.write(this.serialize(o));
			fw.close();
		} catch (IOException e) {
			System.out.println("Trouble printing XML to file");
		}
		return aFile;
	}

	public Object deserialize(File aFile){
		XStream mySerializer = new XStream(new DomDriver());
		return mySerializer.fromXML(aFile);
	}

	public Object loadFromFile(Object o, String aFilePath, String aFileName){
		File aFile = new File(aFilePath + aFileName + ".xml");
		return deserialize(aFile);
	}

	public Object loadFromFile(File aFile){
		return deserialize(aFile);
	}
}
