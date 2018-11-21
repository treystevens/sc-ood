package models;

import java.util.LinkedList;

public abstract class Subject {

    private LinkedList<Observer> observers = new LinkedList<>();


    public void addObserver(Observer o){
        if(!observers.contains(o)) observers.add(o);
    }

    public void notifyObservers(Subject observable, double newBid){

        for(Observer o : observers){
            o.update(observable, newBid);
        }
    }

}
