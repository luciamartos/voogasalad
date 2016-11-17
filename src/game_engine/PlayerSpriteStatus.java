package game_engine;

import javafx.scene.image.Image;

public class PlayerSpriteStatus {
	
	private double xCordinate;
	private double yCordinate;
	private Image playerImage;
	private int lifePlayer;
	private int scorePlayer;

	public PlayerSpriteStatus(double xCordinate, double yCordinate, Image playerImage, int lifePlayer, int scorePlayer) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.playerImage = playerImage;
		this.lifePlayer = lifePlayer;
		this.scorePlayer = scorePlayer;
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
	
	public int getLifePlayer() {
		return lifePlayer;
	}

	public void setLifePlayer(int lifePlayer) {
		this.lifePlayer = lifePlayer;
	}

	public int getScorePlayer() {
		return scorePlayer;
	}

	public void setScorePlayer(int scorePlayer) {
		this.scorePlayer = scorePlayer;
	}
	
	

}
