package author.model.presets;

import game_data.Location;
import game_data.Sprite;
import game_data.sprites.Player;

public enum TestSprite {
	MARIO(new Player(new Location(0, 0, 0), 0, 0, "src/author/images/marioSMBW.png", "Mario")),
	DUKE(new Player(new Location(10, 10, 10),0, 0, "src/author/images/duke.gif", "Duke"));
	
	Sprite mySprite;
	
	private TestSprite(Sprite aSprite){
		mySprite = aSprite;
	}
	
	public Sprite getSprite(){
		return mySprite;
	}
	
}
