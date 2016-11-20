package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLLoader {

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
