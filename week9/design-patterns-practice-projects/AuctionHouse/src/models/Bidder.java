package models;


public class Bidder implements Observer{

    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid, Auctioneer auctioneer){
        this.name = name;
        personalBid = 0;
        currentBid = 0;
        this.maxBid = maxBid;
        auctioneer.addObserver(this);
    }

    public String getName() {
        return name;
    }
    public double getPersonalBid() {
        return personalBid;
    }
    public double getCurrentBid() {
        return currentBid;
    }
    public double getMaxBid() {
        return maxBid;
    }


    public void makeBid(double currentBid){

        double random = Math.floor((Math.random() + .1) * 10);
        personalBid = currentBid + random;

        System.out.println(name + "'s bid is: $" + personalBid);
    }


    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param auctioneer   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Subject auctioneer, Object arg) {

        this.currentBid = (double) arg;
        System.out.println("Update received for: " + name + ", current bid is at: $" + currentBid);
//        System.out.println("Updated bidder with the most recent high bid: " + arg);


        if (currentBid < maxBid) {
            makeBid(currentBid);
        } else {
            System.out.println(name + " can't bid any higher!");
        }
    }

}
