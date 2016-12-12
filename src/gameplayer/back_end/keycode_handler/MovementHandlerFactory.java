package gameplayer.back_end.keycode_handler;

import game_data.ScrollType;

public class MovementHandlerFactory {
	
	public XYMovementHandler buildMovementHandler(double aXLocation, double aYLocation, 
			double aScreenWidth, double aScreenHeight, ScrollType aTypeOfMovement) {
		double XMovement = 0;
		double YMovement = 0;
		if (aTypeOfMovement.equals(ScrollType.HORIZONTAL_RIGHT) || aTypeOfMovement.equals(ScrollType.HORIZONTAL_LEFT)) {
			XMovement = calculateMovement(aXLocation, aScreenWidth);
		} else if (aTypeOfMovement.equals(ScrollType.VERTICAL_UP) || aTypeOfMovement.equals(ScrollType.VERTICAL_DOWN)) {
			YMovement = calculateMovement(aYLocation, aScreenHeight);
		} else if (aTypeOfMovement.equals(ScrollType.CENTER)){
			XMovement = calculateMovement(aXLocation, aScreenWidth);
			YMovement = calculateMovement(aYLocation, aScreenHeight);
		} //else if (aTypeOfMovement.equals(ScrollType.))
		return new XYMovementHandler(XMovement, YMovement);
	}
	
	private double calculateMovement(double aLocation, double aScreenParam) {
		double answer = aLocation - (aScreenParam * .5); 
		return answer;
	}

}
