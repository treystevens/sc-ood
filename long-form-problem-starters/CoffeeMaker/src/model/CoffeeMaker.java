package model;

import model.exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int remainingCups;
    private int lastBrew;

    public CoffeeMaker(){
        remainingCups = 0;
        lastBrew = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return lastBrew;
    }
    public int getCupsRemaining() {
        return remainingCups;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return remainingCups > 0;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        lastBrew = time;
    }


    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    //         throws TooManyBeansException when beans > 2.60 cups
    //         throws NotEnoughBeansException when < 2.40 cups
    //         throws WaterException when water < 14.75cups
    public void brew (double beans, double water) throws BeansAmountException, WaterException{
        System.out.println("Starting to brew...");

        if(beans > 2.60){
            throw new TooManyBeansException(beans);
        }
        if(beans < 2.40){
            throw new NotEnoughBeansException(beans);
        }
        if(water < 14.65){
            throw new WaterException(water);
        }

        remainingCups = 15;
        lastBrew = 0;

        System.out.println("Finished brewing!");
    }


    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          throws NoCupsReaminingException when cups remaining == 0
    //          throws StaleCoffeeException when the last brew > 60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException{
        if(getCupsRemaining() == 0){
            throw new NoCupsRemainingException();
        }
        else if(getTimeSinceLastBrew() > 60){
            throw new StaleCoffeeException(getTimeSinceLastBrew());
        }
        else{
            remainingCups--;

            System.out.println("Pouring coffee... ");
            System.out.println("Enjoy!");
        }


    }


}
