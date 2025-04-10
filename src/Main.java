import Models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        List<Bid> bids = new ArrayList<>();

        Car bil1 = new Car("Toyota","Corolla",2004,19999.99,"TC 54345");
        Car bil2 = new Car("Toyota","Corolla",2001,9999.99,"TC 63463");
        Car bil3 = new Car("Toyota","Corolla",2008,29999.99,"TC 92342");

        cars.add(bil1);
        cars.add(bil2);
        cars.add(bil3);

        for(Car c:cars){
            System.out.println(c.toString());
        }
        Collections.sort(cars);
        for(Car c:cars){
            System.out.println(c.toString());
        }

        bids.add(new Bid("Bob",25000,bil1));
        bids.add(new Bid("John",12000,bil2));
        bids.add(new Bid("Bobby",34999.99,bil3));
        bids.add(new Bid("Bo",27000,bil1));
        bids.add(new Bid("Johnny",29000,bil1));


    }
}
