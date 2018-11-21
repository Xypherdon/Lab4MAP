package model;

public class MicMan {
    private static MicMan ourInstance = new MicMan();

    public static MicMan getInstance() {
        return ourInstance;
    }

    private MicMan() {

    }

    public Position position = new Position();

}
