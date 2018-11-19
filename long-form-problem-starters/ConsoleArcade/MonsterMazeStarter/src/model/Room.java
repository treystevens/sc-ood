package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends Choice{

    private List<Choice> choices;
    private int id;


    public Room(int id) {
        super("Enter Room " + id + ".");
        this.id = id;
        choices = new ArrayList<>();
    }


    //EFFECTS: prints all possible next choices
    @Override
    public void printOutcome() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");

        int counter = 1;

        for (Choice c: choices) {
            System.out.print("\tOption " + counter + ": ");
            c.printOptionMessage();
            counter++;
        }


    }

    //MODIFIES: this
    //EFFECTS: adds m to next possible monsters
    public void addChoice(Choice c) {
        choices.add(c);
    }


    //getters for gameplay

    public Choice getChoice(int i) {
        return choices.get(i);
    }


    public int getChoiceRange() {
        return choices.size();
    }

}
