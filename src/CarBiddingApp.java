import Comparators.*;
import Controller.Controller;
import Models.*;
import Repository.*;
import Services.BidService;
import Services.CarService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarBiddingApp {
    public static void main(String[] args) {
        CarRepository carRepository = new InMemoryCarRepository();
        BidRepository bidRepository = new InMemoryBidRepository();

        CarService carService = new CarService(carRepository);
        BidService bidService = new BidService(carRepository,bidRepository);

        Controller controller = new Controller(carService,bidService);
        controller.start();
    }
}
