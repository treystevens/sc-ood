package model;

import model.observer_pattern.Observer;
import model.observer_pattern.Subject;
import model.random.BingoNumber;

import java.util.ArrayList;
import java.util.List;

public class Game extends Subject {

    public static final int CARD_SIZE = 25;
    public static final int SIDE_LENGTH = (int) Math.sqrt(CARD_SIZE);

    private BingoNumber currentCall;
    private boolean gameOver;

    public Game() {
        callNext();
    }

    //getters
    public BingoNumber getCurrentCall(){
        return currentCall;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public List<PlayerCard> getCards() {
        List<PlayerCard> playerCards = new ArrayList<>();
        for (Observer o : getObservers()) {
            if (o.getClass().getSimpleName().equals("PlayerCard"))
                playerCards.add((PlayerCard) o);
        }
        return playerCards;
    }


    //EFFECTS: generates the next bingo call and notifies observers
    public void callNext() {
        currentCall = new BingoNumber();
        notifyObservers(currentCall);
        refreshGameOver();
    }

    //MODIFIES: this
    //EFFECTS: adds observer to list of observers
    public void addPlayerCard(PlayerCard pc) {
        addObserver(pc);
    }

    //EFFECTS: sets game over to true if one of the players has bingo
    public void refreshGameOver(){
        for (Observer pc : getObservers()) {
            PlayerCard p = (PlayerCard) pc;
            if (p.hasBingo()) {
                gameOver = true;
                break;
            }
        }
    }
}
