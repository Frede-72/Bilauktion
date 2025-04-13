package Repository;

import Models.Car;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCarRepository implements CarRepository{

    private List<Car> carsInMemory = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        carsInMemory.add(car);
    }

    @Override
    public void removeCar(Car car) {
        carsInMemory.remove(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carsInMemory;
    }

    @Override
    public Car getCarFromPlate(String numberPlate) {
        for (Car c : carsInMemory) {
            if (c.getNumberPlate().equalsIgnoreCase(numberPlate)) {
                return c;
            }
        }
        return null;

    }

    @Override
    public boolean isCarOnAuction(String numberPlate) {
        Car car = getCarFromPlate(numberPlate);
        if (car == null) {
            return false;
        }
        return true;
    }
}
