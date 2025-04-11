package Services;

import Models.Car;
import Repository.CarRepository;

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
        return carRepository.getCarFromNumberPlate(numberPlate);
    }

    public boolean removeCarWithNumberPlate(String numberPlate) {
        Car car = findCarFromNumberPlate(numberPlate);
        if (car == null) {
            return false;
        }
        carRepository.removeCar(findCarFromNumberPlate(numberPlate));
        return true;
    }

    public boolean printAllCars() {
        if (carRepository.getAllCars().isEmpty()) {
            return false;
        }
        for (Car c : carRepository.getAllCars()) {
            System.out.println(c);
        }
        return true;
    }

}
