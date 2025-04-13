package Services;

import Models.Car;
import Repository.CarRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public boolean createCar(String brand, String model, int year, int price, String numberPlate) {

        for (Car c : carRepository.getAllCars()) {
            if (c.getNumberPlate().equalsIgnoreCase(numberPlate)) {
                return false;
            }
        }
        carRepository.addCar(new Car(brand, model, year, price, numberPlate));
        return true;
    }

    public Car findCarFromNumberPlate(String numberPlate) {
        return carRepository.getCarFromPlate(numberPlate);
    }

    public boolean isCarOnAuction(String numberPlate) {
        return carRepository.isCarOnAuction(numberPlate);
    }


    public boolean removeCarWithNumberPlate(String numberPlate) {
        if (isCarOnAuction(numberPlate)) {
            carRepository.removeCar(findCarFromNumberPlate(numberPlate));
            return true;
        }
        return false;
    }

    public boolean printAllCars() {
        if (isEmpty()) {
            return false;
        }
        printCars(carRepository.getAllCars());
        return true;
    }

    public void printAllCarsSorted(Comparator comparator) {
        if (isEmpty()) {
            return;
        }
        List<Car> cars = carRepository.getAllCars();
        Collections.sort(cars, comparator);
        printCars(cars);
    }

    private void printCars(List<Car> cars) {
        for (Car c : cars) {
            System.out.println(c);
        }
    }

    private boolean isEmpty() {
        if (carRepository.getAllCars().isEmpty()) {
            return true;
        }
        return false;
    }

}
