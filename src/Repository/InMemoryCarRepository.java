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
    public Car getCarFromNumberPlate(String numberPlate) {
        for(Car c : carsInMemory){
            if(c.getNumberPlate().equalsIgnoreCase(numberPlate)){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return carsInMemory;
    }
}
