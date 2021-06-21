package main.controller;

import main.model.Car;
import main.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    // Attributes/fields declaration
    private final List<Car> allCars;
    private final List<Customer> allCustomers;
    private final List<Car> rentedCars;
    private final List<Car> availableCars;
    private int carId;
    private int customerId;

    // Controller's constructor
    public Controller() {
        allCars = new ArrayList<>();
        allCustomers = new ArrayList<>();
        rentedCars = new ArrayList<>();
        availableCars = new ArrayList<>();
        carId = 1;
        customerId = 1;
    }

    // Method to add a new car to the system
    public void addNewCar(String name, String brand, String numberPlate, int rentPricePerDay, int costPrice, String color) {
        Car car = new Car(carId++, name, brand, numberPlate, rentPricePerDay, costPrice, color);
        allCars.add(car);
        availableCars.add(car);
    }

    // Method to add a new customer to the system
    public void addNewCustomer(String name, int age, String licenseNumber, String nationalIDNumber) {
        Customer customer = new Customer(customerId++, name, age, licenseNumber, nationalIDNumber);
        allCustomers.add(customer);
    }

    // Method to find a particular car using it's license plate number, hence checking if it exists or not
    public Car findCar(String licensePlateNumber){
        Car car = null;
        for(Car carX: allCars) {
            if(carX.getNumberPlate().equals(licensePlateNumber)) {
                car = carX;
                break;
            }
        }
        return car;
    }

    // Method to find a particular customer using the customer's license number, hence checking if the customer exists or not
    public Customer findCustomer(String licenseNumber, String nationalID){
        Customer customer = null;
        for(Customer customerX: allCustomers) {
            if(customerX.getLicenseNumber().equals(licenseNumber) || customerX.getNationalIDNumber().equals(nationalID)) {
                customer = customerX;
                break;
            }
        }
        return customer;
    }

    // Method to check if there are any cars within the system or available for rent based on the parameter it receives
    private void check(List<Car> availableCars) {
        if (availableCars.size() == 0) {
            System.out.println("There are no cars/No cars available");
            return;
        }
        for(int i = 1; i <= availableCars.size(); i++) {
            System.out.println(i + ". " + availableCars.get(i-1));
        }
    }

    // Method to check available cars for rent
    public void displayAvailableCars() {
        check(availableCars);
    }

    // Method to display all the cars within the system
    public void displayTotalCars() {
        check(allCars);
    }

    // Method to remove a car from the system
    public Car removeCar(String licensePlateNumber) {
        Car toBeRemoved = findCar(licensePlateNumber);
        if (toBeRemoved == null)
            System.out.println("Sorry no car available with license number: " + licensePlateNumber);
        else if(rentedCars.contains(toBeRemoved))
            System.out.println("Sorry can not delete a rented car... Try clearing the customers rent first - OPTION 12");
        else {
            allCars.remove(toBeRemoved);
            availableCars.remove(toBeRemoved);
            System.out.println("CAR DETAILS: " + toBeRemoved + " SUCCESSFULLY REMOVED");
            return toBeRemoved;
        }
        return null;
    }
}
