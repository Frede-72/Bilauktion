package Models;

public class Bid {

    private String bidderName;
    private double amount;
    private Car car;

    public Bid(String bidderName, double amount, Car car){

        this.bidderName = bidderName;
        this.amount = amount;
        this.car = car;

    }

}
