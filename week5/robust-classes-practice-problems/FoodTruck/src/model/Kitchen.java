package model;

import model.exceptions.NoCookException;
import model.exceptions.NoIngredientException;
import model.exceptions.NotEnoughMoneyException;

public class Kitchen {

    private final static int INGREDIENT_PER_TACO = 3;
    private final static int DOLLAR_PER_INGREDIENT = 2;
    private int ingredient;
    private int tacoCount;
    private int balance;
    private boolean cookReady;

    public Kitchen(int initialIngredient, int initialTaco, int balance, boolean cookStatus) {
        ingredient = initialIngredient;
        tacoCount = initialTaco;
        cookReady = cookStatus;
        this.balance = balance;
    }

    // getters
    public int getIngredientCount() { return ingredient; }
    public int getTacoCount() { return tacoCount; }
    public boolean getCookState() { return cookReady; }
    public int getBalance() { return balance; }

    public void setCookStatus(boolean b) {
        cookReady = b;
    }

    // MODIFIES: this
    // EFFECTS:  number is added to tacoCount, and ingredient is decremented accordingly
    //          Throws NoIngredientException if ingredient - (INGREDIENT_PER_TACO * number) < 0
    //          Throws NoCookException if cookReady is false
    public void makeTaco(int number) throws NoCookException, NoIngredientException {
        if(ingredient - (INGREDIENT_PER_TACO * number) < 0){
            throw new NoIngredientException("We don't have enough ingredients!");
        }
        else if(!cookReady){
            throw new NoCookException("The cook is not ready!");
        }
        else{
            ingredient -= (INGREDIENT_PER_TACO * number);
            tacoCount += number;
        }


    }

    // MODIFIES: this
    // EFFECTS: (amount) is added to the ingredient field, and the balance field
    //          is decremented accordingly
    //          Throws NotEnoughMoneyException if balance - (INGREDIENT_PER_TACO * amount) < 0
    public void buyIngredients(int amount) throws NotEnoughMoneyException {
        if(balance - (INGREDIENT_PER_TACO * amount) < 0){
            throw new NotEnoughMoneyException("Not enough money to buy ingredients!");
        }
        else{
            balance -= (DOLLAR_PER_INGREDIENT * amount);
            ingredient += amount;
        }


    }

  



}
