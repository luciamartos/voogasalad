package gameplayer.high_score;

import java.util.Collection;
import java.util.MissingResourceException;

public class HighScore {
	
	//private static final String PACKAGE = "data.";
	//private static final String HIGHSCORE = "HighScoreData";
	
	//private ResourceBundle myHighScoreData;
	
	public HighScore() {
		//myHighScoreData = PropertyResourceBundle.getBundle(PACKAGE + HIGHSCORE);
	}
	
	public void addHighScore(String aUserName, double aScore) {
		
	}
	
	public double getHighScore(String aUserName) throws MissingResourceException {
		//return Double.parseDouble(myHighScoreData.getString(aUserName));
		return 0;
	}
	
	public Collection<String> getUserNamesWithHighScores() {
		//return myHighScoreData.keySet();
		return null;
	}

}
