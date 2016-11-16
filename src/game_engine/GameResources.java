package game_engine;


public enum GameResources {
    GAME_TITLE("GAME TITLE HERE"),
    NORMAL_GRAVITY(9.8);

    private double resourceDouble;
    private String resourceString;

    GameResources(String resource) {
        resourceString = resource;
        resourceDouble = -1;
    }

    GameResources(double resource) {
        resourceString = null;
        resourceDouble = resource;
    }

    public String getResource() {
        return resourceString;
    }

    public double getDoubleResource() {
        return resourceDouble;
    }
}
