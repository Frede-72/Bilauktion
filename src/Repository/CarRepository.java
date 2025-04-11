package Repository;

import Models.Car;

import java.util.List;

public interface CarRepository {

    void addCar(Car car);

    void removeCar(Car car);

    Car getCarFromNumberPlate(String numberPlate);

    List<Car> getAllCars();
}
