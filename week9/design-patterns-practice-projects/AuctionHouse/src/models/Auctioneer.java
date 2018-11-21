package models;

public class Auctioneer extends Subject {


    private String name;
    private double currentBid;

    public Auctioneer(String name){
        this.name = name;
        currentBid = 0;
    }


    public String getName() {
        return name;
    }

    public double getCurrentBid() {
        return currentBid;
    }


    public void acceptBid(double bid){
        if(bid <= currentBid){
            System.out.println("That bid isn't larger than the current bid: " + currentBid);
        }
        else{
            currentBid = bid;
            notifyObservers(bid);

        }
    }


    private void notifyObservers(double newBid) {
        System.out.println("Notifying bidders of the new highest bid...");
        super.notifyObservers(this, newBid);
    }


}
