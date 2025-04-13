package Services;

import Models.Bid;
import Models.Car;
import Repository.BidRepository;
import Repository.CarRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BidService {

    private CarRepository carRepository;
    private BidRepository bidRepository;

    public BidService(CarRepository carRepository, BidRepository bidRepository) {

        this.carRepository = carRepository;
        this.bidRepository = bidRepository;

    }

    public boolean makeBid(String name, String plate, int bid) {
        Car car = carRepository.getCarFromPlate(plate);
        if (carRepository.isCarOnAuction(plate)&&carRepository.getCarFromPlate(plate).getPrice()<=bid) {
            bidRepository.makeBid(new Bid(name, bid, car));
            return true;
        }
        return false;
    }

    public void removeBid(Bid bid) {
        bidRepository.removeBid(bid);
    }

    public void removeAllBidsForCar(String plate) {
        List<Bid> bids = bidRepository.getAllBids();
        for (Bid b : bids) {
            if (b.getCar().getNumberPlate().equalsIgnoreCase(plate)) {
                removeBid(b);
            }
        }
    }

    public void printSortedBids(Comparator comparator) {
        if (bidRepository.getAllBids().isEmpty()) {
            System.out.println("No active bids");
            return;
        }
        List<Bid> bids = bidRepository.getAllBids();
        Collections.sort(bids, comparator);
        for (Bid b : bids) {
            System.out.println(b);
        }
    }

    public void printHighestBidForCar(String numberPlate) {
        if (carRepository.isCarOnAuction(numberPlate)) {
            Bid bid = new Bid(null, 0, carRepository.getCarFromPlate(numberPlate));
            for (Bid b : bidRepository.getAllBids()) {
                if (b.getCar().getNumberPlate().equalsIgnoreCase(numberPlate) &&
                        bid.getAmount() < b.getAmount()) {
                    bid = b;
                }
            }
            if (bid.getAmount() <= 0) {
                System.out.println("There is no active bids for " + carRepository.getCarFromPlate(numberPlate));
            } else {
                System.out.println(bid);
            }
        } else {
            System.out.println("Car is not on auction");
        }
    }

    public void printHighestBidForAllCars() {
        for (Car c : carRepository.getAllCars()) {
            printHighestBidForCar(c.getNumberPlate());
        }
    }

    public void printBidsForCar(String plate,Comparator comparator){
        List<Bid> bids = new ArrayList<>();
        Collections.sort(bids, comparator);
        for (Bid b : bidRepository.getAllBids()) {
            if(b.getCar().getNumberPlate().equalsIgnoreCase(plate)){
                bids.add(b);
            }
        }
        if(bids.isEmpty()){
            System.out.println("No active bids for " + plate);
            return;
        }
        Collections.sort(bids,comparator);
        for(Bid b:bids){
            System.out.println(b);
        }
    }

}
