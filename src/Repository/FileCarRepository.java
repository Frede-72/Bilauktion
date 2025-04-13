package Repository;

import Models.Car;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCarRepository implements CarRepository {

    private String carFile;
    private Path path;

    public FileCarRepository(String carFile) {
        this.carFile = carFile;
        this.path = Paths.get(carFile);
    }

    @Override
    public void addCar(Car car) {
        try (FileOutputStream out = new FileOutputStream(carFile,true)) {
            try(PrintStream writer = new PrintStream(out)) {
                writer.append(car.getBrand()+";"+car.getModel()+";"+car.getYear()+";"+car.getPrice()+";"+car.getNumberPlate()+"\n");
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeCar(Car car) {
        List<Car> cars = getAllCars();
        for (Car c : cars) {
            if (c.getNumberPlate().equalsIgnoreCase(car.getNumberPlate())) {
                cars.remove(c);
                try {
                    FileOutputStream out = new FileOutputStream(carFile);
                    PrintStream writer = new PrintStream(out);
                    writer.print("");
                    out.close();
                    writer.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        for (Car c : cars) {
            addCar(c);
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try {
            Scanner reader = new Scanner(path);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] splitLine = line.split(";");
                cars.add(new Car(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]),
                        Integer.parseInt(splitLine[3]), splitLine[4]));
            }
            reader.close();
            return cars;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car getCarFromPlate(String numberPlate) {
        List<Car> cars = getAllCars();
        for (Car c : cars) {
            if (c.getNumberPlate().equalsIgnoreCase(numberPlate)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean isCarOnAuction(String numberPlate) {
        if (getCarFromPlate(numberPlate) != null) {
            return true;
        }
        return false;
    }
}
