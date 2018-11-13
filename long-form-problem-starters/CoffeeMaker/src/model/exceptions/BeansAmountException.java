package model.exceptions;

public class BeansAmountException extends Exception{

    private double beans;

    protected BeansAmountException(double beans, String message){
        super(beans + message);

        this.beans = beans;
    }

    public double getBeans(){ return beans; }
}
