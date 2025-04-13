import Comparators.*;
import Services.BidService;
import Services.CarService;

import java.util.Comparator;
import java.util.Scanner;

public class Controller {

    private CarService carService;
    private BidService bidService;
    private Scanner sc = new Scanner(System.in);
    private Comparator carPriceComparator = new CarPriceComparator();
    private Comparator carBrandComparator = new CarBrandComparator();
    private Comparator bidAmountComparator = new BidAmountComparator();
    private Comparator bidCarComparator = new BidCarComparator();
    private Comparator bidderNameComparator = new BidderNameComparator();

    public Controller(CarService carService, BidService bidService) {

        this.carService = carService;
        this.bidService = bidService;

    }

    public void start() {
        while (true) {
            System.out.println("0 - to exit, 1 - Show list of cars, 2 - Show bids, 3 - List a new car, 4 - Place a new bid, 5 - Remove finished auction");
            int userChoice = getUserInput(5, 0);
            switch (userChoice) {
                case 1:
                    showCars();
                    break;
                case 2:
                    showBids();
                    break;
                case 3:
                    newCar();
                    break;
                case 4:
                    newBid();
                    break;
                case 5:
                    removeCar();
                    break;
                default:
                    return;
            }

        }
    }

    private void showCars() {
        if (!carService.printAllCars()) {
            System.out.println("There is currently no cars on auction");
            return;
        }
        while (true) {
            System.out.println("0 - Return to menu, 1 - Sort list by brand, 2 - Sort list by starting price");
            int userChoice = getUserInput(2, 0);
            switch (userChoice) {
                case 1:
                    carService.printAllCarsSorted(carBrandComparator);
                    break;
                case 2:
                    carService.printAllCarsSorted(carPriceComparator);
                    break;
                default:
                    return;
            }
        }
    }

    private void showBids() {
        while (true) {
            System.out.println("0 - Return to menu, 1 - Show highest bid for all cars, 2 - show bids for one car, 3 - Show all bids");
            int userChoice = getUserInput(3, 0);
            switch (userChoice) {
                case 1:
                    bidService.printHighestBidForAllCars();
                    break;
                case 2:
                    System.out.println("Enter the numberplate of the car you want to view bids");
                    String plate = getNonEmptyString();
                    bidService.printBidsForCar(plate,bidAmountComparator);
                    break;
                case 3:
                    sortBids();
                    break;
                default:
                    return;
            }
        }
    }

    private void sortBids() {
        while (true) {
            System.out.println("0 - Return to menu, 1 - Sort bids by amount, 2 - Sort bids by name, 3  - Sort bids by car");
            int userChoice = getUserInput(3, 0);
            switch (userChoice) {
                case 1:
                    bidService.printSortedBids(bidAmountComparator);
                    break;
                case 2:
                    bidService.printSortedBids(bidderNameComparator);
                    break;
                case 3:
                    bidService.printSortedBids(bidCarComparator);
                    break;
                default:
                    return;
            }
        }
    }

    private void newBid() {
        System.out.println("Enter your name");
        String name = getNonEmptyString();
        System.out.println("Enter the numberplate for the car you are making a bid");
        String plate = getNonEmptyString();
        System.out.println("Enter your bid");
        int bid = getInt();
        if (!bidService.makeBid(name, plate, bid)) {
            System.out.println(("Could not create bid"));
        }
    }

    private void newCar() {
        System.out.println("Enter the numberplate");
        String plate = getNonEmptyString();
        System.out.println("Enter the car brand");
        String brand = getNonEmptyString();
        System.out.println("Enter the model");
        String model = getNonEmptyString();
        System.out.println("Enter the year");
        int year = getInt();
        System.out.println("Enter the starting price");
        int price = getInt();
        if (carService.createCar(brand, model, year, price, plate)) {
            System.out.println("New auction for " + plate + " created");
        } else {
            System.out.println("A car with the same numberplate is already on auction");
        }
    }

    private void removeCar() {
        System.out.println("Enter the numberplate of the car to remove");
        String plate = getNonEmptyString();
        if (carService.removeCarWithNumberPlate(plate)) {
            bidService.removeAllBidsForCar(plate);
            System.out.println(plate + " removed");
        } else {
            System.out.println("Numberplate doesn't exit");
        }
    }


    private int getUserInput(int choiceUpperBoundary, int choiceLowerBoundary) {
        int userInput;

        do {
            while (!sc.hasNextInt()) {

                sc.next();

            }
            userInput = sc.nextInt();
            sc.nextLine();
        } while (userInput > choiceUpperBoundary || userInput < choiceLowerBoundary);

        return userInput;
    }

    private int getInt() {
        int userInput;
        while (!sc.hasNextInt()) {

            sc.next();

        }
        userInput = sc.nextInt();
        sc.nextLine();
        return userInput;
    }

    private String getNonEmptyString() {
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.isEmpty()) {
                continue;
            }
            break;
        }
        return input;
    }

}
