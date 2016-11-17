package game_engine;
import java.util.List;

import game_data.Sprite;
import game_data.Level;
import game_data.Location;
import game_data.Character;
public class EnginePlayerController {
	private Level myLevel;
	private int myWidth, myHeight;
	private String myBackgroundImageFilePath;
	private List<Sprite> mySpriteList;
	private List<Integer> mySpriteXCoordinateList;
	private List<Integer> mySpriteYCoordinateList;
	private List<Integer> mySpriteHeadingList;
	private List<String> mySpriteImagePathList;
	private List<Integer> mySpriteHealthList;
	private List<Boolean> mySpriteIsAliveList;
	public EnginePlayerController(){
		myLevel=null;
		mySpriteList=null;
		myBackgroundImageFilePath=null;
		myWidth=0;
		myHeight=0;
		mySpriteXCoordinateList=null;
		mySpriteYCoordinateList=null;
		mySpriteHeadingList=null;
		mySpriteImagePathList=null;
		mySpriteHealthList=null;
		mySpriteIsAliveList=null;
	}
	public EnginePlayerController(Level aLevel) {
		myLevel=aLevel;
		mySpriteList=myLevel.getMySpriteList();
		myBackgroundImageFilePath=myLevel.getBackgroundImageFilePath();
		myWidth=myLevel.getWidth();
		myHeight=myLevel.getHeight();
		updateSpriteData();
	}
	public void updateControllerData(){
		mySpriteList=myLevel.getMySpriteList();
		myBackgroundImageFilePath=myLevel.getBackgroundImageFilePath();
		myWidth=myLevel.getWidth();
		myHeight=myLevel.getHeight();
		updateSpriteData();
	}
	private void updateSpriteData(){
		for(int i=0; i<mySpriteList.size(); i++){
			Object sprite = mySpriteList.get(i);
			mySpriteImagePathList.set(i, ((Sprite) sprite).getMyImagePath());
			Location location = ((Sprite) sprite).getMyLocation();
			mySpriteXCoordinateList.set(i, location.getXLocation());
			mySpriteYCoordinateList.set(i, location.getYLocation());
			mySpriteHeadingList.set(i, location.getMyHeading());
			if(sprite instanceof Character){
				mySpriteHealthList.set(i, ((Character) sprite).getMyHealth());
				mySpriteIsAliveList.set(i, ((Character) sprite).isAlive());
			}
			else{
				mySpriteHealthList.set(i, null);
				mySpriteIsAliveList.set(i, null);
			}
		}
	}
	public Level getMyLevel() {
		return myLevel;
	}
	public int getMyWidth() {
		return myWidth;
	}
	public int getMyHeight() {
		return myHeight;
	}
	public String getMyBackgroundImageFilePath() {
		return myBackgroundImageFilePath;
	}
	public List<Sprite> getMySpriteList() {
		return mySpriteList;
	}
	public List<Integer> getMySpriteXCoordinateList() {
		return mySpriteXCoordinateList;
	}
	public List<Integer> getMySpriteYCoordinateList() {
		return mySpriteYCoordinateList;
	}
	public List<Integer> getMySpriteHeadingList() {
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
}
