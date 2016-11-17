package game_data;


public class Character extends Sprite {
	private int myHealth;
	private boolean myIsAlive;
	public Character(Location aLocation, String aImagePath, int aHealth) {
		super(aLocation, aImagePath);
		myIsAlive=true;
	}
	public int getMyHealth(){
		return myHealth;
	}
	public void setMyHealth(int aHealth){
		myHealth+=aHealth;
		updateIsAlive();
	}
	public boolean isAlive(){
		return myIsAlive;
	}
	private void updateIsAlive(){
		if(myHealth<=0){
			myIsAlive=false;
		}
	}
}
