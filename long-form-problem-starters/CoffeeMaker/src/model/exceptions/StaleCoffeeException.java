package model.exceptions;

public class StaleCoffeeException extends Exception{
    private int lastBrew;

    public StaleCoffeeException(int lastBrew){
        super("Time since last brew: " + lastBrew);

        this.lastBrew = lastBrew;
    }

    public int getLastBrew() {
        return lastBrew;
    }
}
