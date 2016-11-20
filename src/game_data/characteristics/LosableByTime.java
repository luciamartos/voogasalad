package game_data.characteristics;

public class LosableByTime extends Losable implements Characteristic{

	private double myTime;
	
	public LosableByTime(double time){
		myTime = time;
	}
	
	public double getTime(){
		return myTime;
	}
	
	public boolean outOfTime(){
		return myTime<=0;
	}
	
	@Override
	public boolean toAct() {
		//check time in here?
		//time-=timestep?
		return true;
	}

	@Override
	public Characteristic copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
