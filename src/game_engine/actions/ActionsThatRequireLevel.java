package game_engine.actions;

public interface ActionsThatRequireLevel extends LevelSetter, Action {
	public void setLevel();
}
