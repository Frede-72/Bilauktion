import Comparators.*;
import Models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarBrandComparator brandComparator = new CarBrandComparator();
        CarPriceComparator priceComparator = new CarPriceComparator();
        BidAmountComparator bidAmountComparator = new BidAmountComparator();
        BidderNameComparator bidderNameComparator = new BidderNameComparator();
        BidCarComparator carComparator = new BidCarComparator();

        List<Car> cars = new ArrayList<>();
        List<Bid> bids = new ArrayList<>();

        Car bil1 = new Car("Yota","Corolla",2004,19999,"TC 54345");
        Car bil2 = new Car("Oyota","Corolla",2001,99999,"TC 63463");
        Car bil3 = new Car("Toyota","Corolla",2008,29999,"TC 92342");

        cars.add(bil1);
        cars.add(bil2);
        cars.add(bil3);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort by year");
        Collections.sort(cars);
        printList(cars);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort by brand");
        Collections.sort(cars,brandComparator);
        printList(cars);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort by starting price");
        Collections.sort(cars,priceComparator);
        printList(cars);

        bids.add(new Bid("Bob",25000,bil1));
        bids.add(new Bid("John",12000,bil2));
        bids.add(new Bid("Bobby",34999,bil3));
        bids.add(new Bid("Bo",27000,bil1));
        bids.add(new Bid("Johnny",29000,bil1));
        bids.add(new Bid("Joe",15000,bil2));
        bids.add(new Bid("Joey",30000,bil3));

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort bids by bidder name");
        Collections.sort(bids,bidderNameComparator);
        printList(bids);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort bids by amount, highest first");
        Collections.sort(bids,bidAmountComparator);
        printList(bids);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Sort bids by car");
        Collections.sort(bids,carComparator);
        printList(bids);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Highest bid for each car");
        for(Car c : cars){
            Bid highest = new Bid("e",0,c);
            for(Bid b:bids){
                if(highest.getAmount()<b.getAmount()&&
                        highest.getCar().getNumberPlate().equals(b.getCar().getNumberPlate())){
                    highest = b;
                }
            }
            System.out.println(highest);
        }
    }

    public static void printList(List list){
        for(Object o : list){
            System.out.println(o);
        }
    }
}
