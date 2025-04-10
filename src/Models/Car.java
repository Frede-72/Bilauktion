package Models;

public class Car implements Comparable<Car> {

    private String brand;
    private String model;
    private int year;
    private double price;
    private String numberPlate;

    public Car(String brand,String model,int year,double price,String numberPlate){

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.numberPlate = numberPlate;

    }

    public int getYear(){
        return year;
    }

    @Override
    public int compareTo(Car o) {
        return year-o.getYear();
    }

    public String toString(){
        return brand + " " + model + " " + year + " Starting price:" + price + " numberPlate: "+ numberPlate;
    }
}
