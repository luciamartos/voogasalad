package game_engine;

import game_data.Game;
import game_data.Level;
import game_data.Location;
import game_data.Sprite;


import game_data.sprites.Character;
import game_data.sprites.Player;
import game_data.states.Health;
import game_data.states.State;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Katrina, Austin, Lucia, ALEX! =D
 *
 */
public class EnginePlayerController implements IEnginePlayerControllerInterface {
	//private Level myLevel;
	private int myWidth, myHeight;
	private String myBackgroundImageFilePath;
	private List<Sprite> mySpriteList;
	private List<Double> mySpriteXCoordinateList;
	private List<Double> mySpriteYCoordinateList;
	private List<Double> mySpriteHeadingList;
	private List<String> mySpriteImagePathList;
	private List<Integer> mySpriteHealthList;
	private List<Boolean> mySpriteIsAliveList;
	private Game myGame;

	public EnginePlayerController() {
		myGame = null;
		mySpriteList = null;
		myBackgroundImageFilePath = "";
		myWidth = 0;
		myHeight = 0;
		mySpriteXCoordinateList = new ArrayList<>();
		mySpriteYCoordinateList = new ArrayList<>();
		mySpriteHeadingList = new ArrayList<>();
		mySpriteImagePathList = new ArrayList<>();
		mySpriteHealthList = new ArrayList<>();
		mySpriteIsAliveList = new ArrayList<>();
	}


	public EnginePlayerController(Game game) {
		myGame = game;
		Level myLevel = myGame.getCurrentLevel();
		
		
		for(Sprite s: myLevel.getMySpriteList()){
			if(s instanceof Player){
			}
		}

		mySpriteList = myLevel.getMySpriteList();
		myBackgroundImageFilePath = myLevel.getBackgroundImageFilePath();
		myWidth = myLevel.getWidth();
		myHeight = myLevel.getHeight();
		mySpriteXCoordinateList = new ArrayList<>();
		mySpriteYCoordinateList = new ArrayList<>();
		mySpriteHeadingList = new ArrayList<>();
		mySpriteImagePathList = new ArrayList<>();
		mySpriteHealthList = new ArrayList<>();
		mySpriteIsAliveList = new ArrayList<>();
		myLevel.setMyControllableSpriteList();
		updateSpriteData();
	}

	public void updateControllerData() {
		Level myLevel=myGame.getCurrentLevel();
		mySpriteList = myLevel.getMySpriteList();
		myBackgroundImageFilePath = myLevel.getBackgroundImageFilePath();
		myWidth = myLevel.getWidth();
		myHeight = myLevel.getHeight();
		updateSpriteData();
	}

	private void updateSpriteData() {
		for (int i = 0; i < mySpriteList.size(); i++) {
			Object sprite = mySpriteList.get(i);
			mySpriteImagePathList.add(((Sprite) sprite).getImagePath());
			Location location = ((Sprite) sprite).getLocation();
			mySpriteXCoordinateList.add(location.getXLocation());
			mySpriteYCoordinateList.add(location.getYLocation());
			if (sprite instanceof Character) {
				for (State myState : ((Character) sprite).getStates()) {
					if (myState instanceof Health) {
						mySpriteHealthList.add(((Health) myState).getMyHealth());
					}
					if (sprite instanceof Health) {
						mySpriteIsAliveList.add(((Health) sprite).isAlive());
					}
				}
			}
		}
	}

	public int getWidth() {
		return myWidth;
	}

	public int getHeight() {
		return myHeight;
	}

	public String getMyBackgroundImageFilePath() {
		return myBackgroundImageFilePath;
	}

	public List<Sprite> getMySpriteList() {
		return myGame.getCurrentLevel().getMySpriteList();
	}

	public List<Double> getMySpriteXCoordinateList() {
		return mySpriteXCoordinateList;
	}

	public List<Double> getMySpriteYCoordinateList() {
		return mySpriteYCoordinateList;
	}

	public List<Double> getMySpriteHeadingList() {
		return mySpriteHeadingList;
	}

	public List<String> getMySpriteImagePathList() {
		return mySpriteImagePathList;
	}

	public List<Integer> getMySpriteHealthList() {
		return mySpriteHealthList;
	}

	public List<Boolean> getMySpriteIsAliveList() {
		return mySpriteIsAliveList;
	}

	public Game getMyGame() {
		return myGame;
	}
}