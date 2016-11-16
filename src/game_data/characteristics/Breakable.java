package game_data.characteristics;

public class Breakable implements Characteristic{

	private boolean breakableNorth;
	private boolean breakableSouth;
	private boolean breakableEast;
	private boolean breakableWest;
	private int myDurability;
	
	public Breakable(boolean north, boolean south, boolean east, boolean west, int durability){
		breakableNorth = north;
		breakableSouth = south;
		breakableEast = east;
		breakableWest = west;
		myDurability = durability;
	}
	
	public int getDurability(){
		return myDurability;
	}
	
	public void decrementDurability(){
		myDurability--;
	}
	
	public boolean isBroken(){
		return myDurability<=0;
	}
	
	public boolean isBreakable(){
		return breakableNorth || breakableSouth || breakableWest || breakableEast;
	}
	
	public void setDurability(int durability){
		myDurability = durability;
	}
	
	@Override
	public void express() {
		// TODO Auto-generated method stub	
		//if breakable north, decrement health when intersection on north edge;
	}

	@Override
	public Characteristic copy() {
		return new Breakable(breakableNorth, breakableSouth, breakableEast, breakableWest, myDurability);
	}

}
