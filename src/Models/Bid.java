package Models;

public class Bid {

    private String bidderName;
    private int amount;
    private Car car;

    public Bid(String bidderName, int amount, Car car){

        this.bidderName = bidderName;
        this.amount = amount;
        this.car = car;

    }

    public String getBidderName(){
        return bidderName;
    }

    public int getAmount(){
        return amount;
    }

    public Car getCar(){
        return car;
    }

    public String toString(){
        return bidderName + " Bid: " + amount + " For " + car.toString();
    }

}
