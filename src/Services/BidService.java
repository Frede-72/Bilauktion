package Services;

import Repository.BidRepository;
import Repository.CarRepository;

public class BidService {

    private CarRepository carRepository;
    private BidRepository bidRepository;

    public BidService(CarRepository carRepository,BidRepository bidRepository){

        this.carRepository = carRepository;
        this.bidRepository = bidRepository;

    }



}
