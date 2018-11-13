package model.exceptions;

public class WaterException extends Exception {

    private double water;

    public WaterException(double water){
        super(water + " not enough water supplied to the machine.");

        this.water = water;
    }

    public double getWater() {
        return water;
    }
}
