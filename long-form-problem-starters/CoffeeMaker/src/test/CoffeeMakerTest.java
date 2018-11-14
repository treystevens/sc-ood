package test;

import model.CoffeeMaker;
import model.exceptions.BeansAmountException;
import model.exceptions.NoCupsRemainingException;
import model.exceptions.StaleCoffeeException;
import model.exceptions.WaterException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;


public class CoffeeMakerTest {

    CoffeeMaker cm;


    @Before
    public void setUp(){
        cm = new CoffeeMaker();
    }

    @Test
    public void gettersTest(){
        assertEquals(0, cm.getCupsRemaining());

        cm.setTimeSinceLastBrew(30);
        assertEquals(30, cm.getTimeSinceLastBrew());

        cm.setTimeSinceLastBrew(40);
        assertEquals(40, cm.getTimeSinceLastBrew());
    }

    @Test
    public void brewTest(){
        try{
            cm.brew(2.50, 16.4);
        }
        catch(BeansAmountException b){
            fail("Too much or not enough beans when shouldn't have");
        }
        catch (WaterException w){
            fail("Not enough water when shouldn't have");
        }

        assertEquals(cm.getTimeSinceLastBrew(), 0);


    }

        @Test
        public void brewNotEnoughBeansTest(){
        try{
            cm.brew(1.10, 18.4);
        }
        catch(BeansAmountException b){
        }
        catch (WaterException w){
            fail("Not enough water when shouldn't have");
        }

        assertEquals(0, cm.getCupsRemaining());
    }

        @Test
        public void brewNotEnoughWaterTest(){
        try{
            cm.brew(2.50, 12.4);
        }
        catch(BeansAmountException b){
            fail("Too much or not enough beans when shouldn't have");
        }
        catch (WaterException w){

        }

        assertEquals(0, cm.getCupsRemaining());
    }

        @Test
        public void brewNotEnoughBeansWaterTest(){
        try{
            cm.brew(2.10, 11.4);
        }
        catch(BeansAmountException b){
            assertEquals(0, cm.getCupsRemaining());
        }
        catch (WaterException w){
            fail("Should reach not enough or too many beans exception first");
        }

        assertEquals(0, cm.getCupsRemaining());
    }


    @Test
    public void pourCoffeeTest(){

        brewTest();

        cm.setTimeSinceLastBrew(40);

        try{
            cm.pourCoffee();
            cm.pourCoffee();
            cm.pourCoffee();
        }
        catch(NoCupsRemainingException c){
            fail("Should have cups remaining");
        }
        catch (StaleCoffeeException e) {
            fail("Coffee should not be stale yet");
        }

        assertEquals(cm.getCupsRemaining(), 12);
    }

        @Test
        public void pourCoffeeNoCupsTest(){



            try{
                for(int i=0; i<15; i++){
                    cm.pourCoffee();
                }
            }
            catch(NoCupsRemainingException c){

            }
            catch (StaleCoffeeException e) {
                fail("Coffee should not be stale yet");
            }

            assertEquals(0, cm.getCupsRemaining());
        }

        @Test
        public void pourCoffeeStaleTest(){


            brewTest();
            cm.setTimeSinceLastBrew(90);

            try{
                cm.pourCoffee();
            }
            catch(NoCupsRemainingException c){
                fail("Should have cups remaining");
            }
            catch (StaleCoffeeException e) {
            }
        }

        @Test
        public void pourCoffeeStaleNoCupsTest(){

            brewTest();
            cm.setTimeSinceLastBrew(100);

            try{
                for(int i=0; i<15; i++){
                    cm.pourCoffee();
                }

            }
            catch(NoCupsRemainingException c){
                fail("StaleCoffeeException should catch the problem");
            }
            catch (StaleCoffeeException e) {

            }

            assertEquals(15, cm.getCupsRemaining());


        }




}
