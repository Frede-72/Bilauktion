package Repository;

import Models.Car;

import java.util.List;

public interface CarRepository {

    void addCar(Car car);

    void removeCar(Car car);

    List<Car> getAllCars();

    Car getCarFromPlate(String numberPlate);

    boolean isCarOnAuction(String numberPlate);
}
