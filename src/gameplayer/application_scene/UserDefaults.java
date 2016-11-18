package gameplayer.application_scene;

import java.util.prefs.Preferences;

public class UserDefaults {
	
	Preferences myPrefs;
	private static final String FONT_COLOR = "fontcolor";
	private static final String KEY_INPUT = "keyinput";
	
	public UserDefaults(String path){
		myPrefs = Preferences.userRoot().node(path);
	}
	
	public void setFontColor(String value){
		myPrefs.put(FONT_COLOR, value);
	}
	
	public String getFontColor(String def){
		return myPrefs.get(FONT_COLOR, def);
	}
	
	public void setKeyInput(int value){
		myPrefs.putInt(KEY_INPUT, value);
	}
	
	public int getKeyInput(int def){
		return myPrefs.getInt(KEY_INPUT, def);
	}
}
