import Repository.*;
import Services.BidService;
import Services.CarService;

public class CarBiddingApp {
    public static void main(String[] args){
        //CarRepository carRepository = new InMemoryCarRepository();
        CarRepository carRepository = new FileCarRepository("cars.txt");
        //BidRepository bidRepository = new InMemoryBidRepository();
        BidRepository bidRepository = new FileBidRepository("bids.txt");

        CarService carService = new CarService(carRepository);
        BidService bidService = new BidService(carRepository,bidRepository);

        Controller controller = new Controller(carService,bidService);
        controller.start();
    }
}
