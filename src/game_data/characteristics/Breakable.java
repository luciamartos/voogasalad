/*
 * Authors: Alex + Austin
 * 
 * if toAct() is true run the following:
 * isBroken()
 * 
 */

package game_data.characteristics;

public class Breakable implements Characteristic{

	private boolean breakableNorth;
	private boolean breakableSouth;
	private boolean breakableEast;
	private boolean breakableWest;
	private int myDurability;
	private final String NORTH = "NORTH";
	private final String SOUTH = "SOUTH";
	private final String EAST = "EAST";
	private final String WEST = "WEST";
	
	public Breakable(boolean north, boolean south, boolean east, boolean west, int durability){
		breakableNorth = north;
		breakableSouth = south;
		breakableEast = east;
		breakableWest = west;
		myDurability = durability;
	}
	
	public void setDurability(int durability){
		myDurability = durability;
	}
	
	private boolean breakable() {
		return breakableNorth || breakableSouth || breakableEast || breakableWest;
	}
	
	@Override
	public boolean toAct() {
		return breakable();
	}
	
	public boolean isBroken(String aDirection){
		
		if( ! breaksAtDirection(aDirection))
			return false;
		
		myDurability--;
		return myDurability<=0;
	}
	
	private boolean breaksAtDirection(String aDirection) {
		if(aDirection.equals(NORTH)) {
			return breakableNorth;
		} else if(aDirection.equals(SOUTH)) {
			return breakableSouth;
		} else if(aDirection.equals(EAST)) {
			return breakableEast;
		} else if(aDirection.equals(WEST)) {
			return breakableWest;
		} 
		return false;
	}

	@Override
	public Characteristic copy() {
		return new Breakable(breakableNorth, breakableSouth, breakableEast, breakableWest, myDurability);
	}

}
