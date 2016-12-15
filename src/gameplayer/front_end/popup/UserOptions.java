package gameplayer.front_end.popup;


public class UserOptions {

	private String myFontColor;
	private String myKeyInput;
	
	public UserOptions(String aFontColor, String aKeyInput) {
		setMyFontColor(aFontColor);
		setMyKeyInput(aKeyInput);
	}
	
	public UserOptions() {
		setMyKeyInput("Default");
	}

	public String getMyKeyInput() {
		return myKeyInput;
	}

	public void setMyKeyInput(String aKeyInput) {
		myKeyInput = aKeyInput == null ? "default": aKeyInput;
	}

	public String getMyFontColor() {
		return myFontColor;
	}

	public void setMyFontColor(String aFontColor) {
		myFontColor = aFontColor == null ? "#fdbe3b" : aFontColor;
	}
}
