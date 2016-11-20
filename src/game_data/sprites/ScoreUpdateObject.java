package game_data.sprites;

import game_data.Location;
import game_data.Sprite;
/**
 * @author austingartside
 *
 */

public class ScoreUpdateObject extends Sprite{
	
	private int myScoreToAdd;

	public ScoreUpdateObject(Location aLocation, String aImagePath, int scoreToAdd) {
		super(aLocation, aImagePath);
		myScoreToAdd = scoreToAdd;
	}
	
	public ScoreUpdateObject(ScoreUpdateObject aScoreUpdateObject){
		super(aScoreUpdateObject);
	}

	@Override
	public Sprite clone() {
		return new ScoreUpdateObject(this);
	}
	
	public int getScoreToAdd(){
		return myScoreToAdd;
	}

}
