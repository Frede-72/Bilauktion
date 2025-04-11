package Controller;

import Exceptions.NoCarsException;
import Services.BidService;
import Services.CarService;

import java.util.Scanner;

public class Controller {

    private CarService carService;
    private BidService bidService;
    private Scanner sc = new Scanner(System.in);

    public Controller(CarService carService,BidService bidService){

        this.carService = carService;
        this.bidService = bidService;

    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("0 - to exit, 1 - Show list of cars, 2 - Place a new bid, 3 - List a new car, 4 - Remove finished auction");
            int userChoice = getUserInput(4,0);
            switch (userChoice) {
                case 1:
                    showCars();
                    break;
                case 2:
                    newBid();
                    break;
                case 3:
                    newCar();
                    break;
                case 4:
                    removeCar();
                    break;
                default:
                    return;
            }

        }
    }

    private void showCars(){
        if(!carService.printAllCars()){
            throw new NoCarsException("There is currently no cars on auction");
        }
    }

    private void newBid(){
        System.out.println("ee");
    }

    private void newCar(){
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
        if(carService.createCar(brand,model,year,price,plate)){
            System.out.println("New auction for " + plate + " created");
        } else{
            System.out.println("A car with the same numberplate is already on auction");
        }
    }

    private void removeCar(){
        System.out.println("Enter the numberplate of the car to remove");
        String plate = getNonEmptyString();
        if(carService.removeCarWithNumberPlate(plate)){
            System.out.println(plate + " removed");
        }
        else{
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

    private int getInt(){
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
