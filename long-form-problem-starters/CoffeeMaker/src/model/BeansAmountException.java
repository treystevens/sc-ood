package model;

public class BeansAmountException extends Exception{

    private double beans;

    public BeansAmountException(double beans){
        super( beans + " is not the right amount of beans");

        this.beans = beans;
    }

    public double getBeans(){ return beans; }
}
