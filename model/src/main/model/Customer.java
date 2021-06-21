package main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for keeping customer details, getting information about customer and setting up details
 */

public class Customer {

    private int customerId;
    private String name;
    private int age;
    private String licenseNumber;
    private String nationalIDNumber;
    private List<Car> carsRented;

    /**
     *
     * @param customerId
     * @param name
     * @param age
     * @param licenseNumber
     * @param nationalIDNumber
     */
    public Customer(int customerId, String name, int age, String licenseNumber, String nationalIDNumber) {
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.licenseNumber = licenseNumber;
        this.nationalIDNumber = nationalIDNumber;
        carsRented = new ArrayList<>();
    }

    /**
     * Getters and Setters
     * @return
     * @setValues
     */

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getNationalIDNumber() {
        return nationalIDNumber;
    }

    public void setNationalIDNumber(String nationalIDNumber) {
        this.nationalIDNumber = nationalIDNumber;
    }

    public List<Car> getCarsRented() {
        return carsRented;
    }

    /**
     * Display in a more clear and detailed way
     * @return
     */
    @Override
    public String toString() {
        return  "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", nationalIDNumber='" + nationalIDNumber + '\'';
    }
}
