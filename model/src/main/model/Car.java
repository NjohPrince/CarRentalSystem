package main.model;

/**
 * Class for keeping car details, getting information about a car and setting up details
 */

public class Car {

    private int carId;
    private String name;
    private String brand;
    private String numberPlate;
    private int rentPricePerDay;
    private int costPrice;
    private String color;
    private Customer currentUser;

    /**
     *
     * @param carId
     * @param name
     * @param brand
     * @param numberPlate
     * @param rentPricePerDay
     * @param costPrice
     * @param color
     */

    public Car(int carId, String name, String brand, String numberPlate, int rentPricePerDay, int costPrice, String color) {
        this.carId = carId;
        this.name = name;
        this.brand = brand;
        this.numberPlate = numberPlate;
        this.rentPricePerDay = rentPricePerDay;
        this.costPrice = costPrice;
        this.color = color;
    }

    
}
