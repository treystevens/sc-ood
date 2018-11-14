package main;

import model.CoffeeMaker;
import model.exceptions.*;

public class Main {

    public static void main(String[] args){

        CoffeeMaker cm = new CoffeeMaker();


        try{
            cm.brew(2.70, 12.4);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


        cm.getCupsRemaining();

        try{
            cm.pourCoffee();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


        cm.setTimeSinceLastBrew(5);

        System.out.println("End of program.");




    }


}