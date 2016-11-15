package game_engine;

import javafx.scene.image.Image;

public class PlayerSpriteStatus {
	
	private double xCordinate;
	private double yCordinate;
	private Image playerImage;

	public PlayerSpriteStatus(double xCordinate, double yCordinate, Image playerImage) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.playerImage = playerImage;
	}
	
	public double getxCordinate() {
		return this.xCordinate;
	}

	public void setxCordinate(double xCordinate) {
		this.xCordinate = xCordinate;
	}

	public double getyCordinate() {
		return this.yCordinate;
	}

	public void setyCordinate(double yCordinate) {
		this.yCordinate = yCordinate;
	}

	public Image getPlayerImage() {
		return this.playerImage;
	}

	public void setPlayerImage(Image playerImage) {
		this.playerImage = playerImage;
	}
	

}
