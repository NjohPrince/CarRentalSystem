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

    // Method to get cars by name
    public void getCarsByName() {
        String name;
        int count = 0;
        boolean test = false;
        System.out.print("Enter name: ");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        for(Car car: allCars) {
            if(car.getName().equals(name)) {
                test = true;
                count++;
                System.out.println(car);
            }
        }
        if(!test) {
            System.out.println("Sorry no car available with name: " + name);
        } else {
            System.out.println("Number of cars with name " + name + ": " + count);
        }
    }
    // Method to get cars by category/brand
    public void getCarsByBrand() {
        String brand;
        int count = 0;
        boolean test = false;
        System.out.print("Enter brand: ");
        Scanner scan = new Scanner(System.in);
        brand = scan.nextLine();
        for(Car car: allCars) {
            if(car.getBrand().equals(brand)) {
                test = true;
                count++;
                System.out.println(car);
            }
        }
        if(!test) {
            System.out.println("Sorry no car available with brand: " + brand);
        } else {
            System.out.println("Number of cars with brand " + brand + ": " + count);
        }
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

    // Method to return a particular customer - Overloading
    public  Customer findCustomer(String licenseNumber) {
        Customer customer = null;
        for(Customer customerX: allCustomers) {
            if(customerX.getLicenseNumber().equals(licenseNumber)) {
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

    // Display all customers
    public void displayCustomers() {
        if(allCustomers.size() == 0) {
            System.out.println("There are no customers");
            return;
        }
        for(int i = 1; i <= allCustomers.size(); i++) {
            System.out.println(i + ". " + allCustomers.get(i-1));
        }
    }

    // Get a customer's rent details
    public void getRentDetails(String licenseNumber) {
        Customer customer = findCustomer(licenseNumber);
        if(customer == null)
            System.out.println("Sorry no customer with license number " + licenseNumber);
        else {
            if(customer.getCarsRented().size() == 0)
                System.out.println("Sorry no car has been rented yet by this customer");
            else
                System.out.println(customer.getCarsRented());
        }
    }

    // Method to display details of a customer
    public void showCustomer(String licenseNumber){
        Customer customer = findCustomer(licenseNumber);
        if (customer == null) System.out.println("No customer found with license number " + licenseNumber);
        else System.out.println(customer);
    }

    // Method to release car from rent
    public void releaseCarFromRent(String licensePlateNumber) {
        Car car = findCar(licensePlateNumber);
        if(car == null) {
            System.out.println("Sorry no car with license plate number: " + licensePlateNumber);
        } else {
            if(rentedCars.contains(car)) {
                rentedCars.remove(car);
                availableCars.add(car);
                car.setCurrentUser(null);
                car.getCurrentUser().getCarsRented().remove(car);
            } else {
                System.out.println("Car is available, not yet given out for rent");
            }
        }
    }

    // Method to remove a customer from the system
    public Customer removeCustomer(String licenseNumber) {
        Customer toBeRemoved = findCustomer(licenseNumber);
        if (toBeRemoved == null)
            return null;
        allCustomers.remove(toBeRemoved);
        return toBeRemoved;
    }

    // Method to show all rents
    public void showAllRents(){
        if(rentedCars.size() == 0)
            System.out.println("No car rented out yet...");
        else {
            System.out.println("Customer License Number    Car License Plate Number");
            for (Car car: rentedCars){
                System.out.println(car.getCurrentUser().getLicenseNumber() + "                      " + car.getNumberPlate());
            }
        }
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

    // Method to modify a car's details based upon choice selection
    public void modifyCarDetails(String licensePlateNumber) {
        Car car = findCar(licensePlateNumber);
        if(car == null) {
            System.out.println("Sorry no car found with license plate number: " + licensePlateNumber);
        } else {
            Scanner sc = new Scanner(System.in);
            int choice;
            System.out.println();
            System.out.println("1. Color");
            System.out.println("2. Price");
            System.out.println("3. RentPerDay");
            System.out.println("4. LicenseNumberPlate");
            System.out.println("5. Color and Price");
            System.out.println("6. Price and RentPerDay");
            System.out.println("7. Color and RentPerDay");
            System.out.println("8. Color and licensePlateNumber");
            System.out.println("9. LicensePlateNumber and RentPerDay");
            System.out.println("10. Color, LicensePlateNumber and RentPerDay");
            System.out.println("11. All car properties [Excluding name and brand properties]");
            System.out.println("\nWhat do you want to edit? ");
            choice = sc.nextInt();

            String numberPlate, color;
            int rentPricePerDay, costPrice;

            switch (choice) {
                case 1 -> {
                    System.out.println();
                    color = sc.nextLine();
                    car.setColor(color);
                    System.out.println("Successfully Updated.");
                }
                case 2 -> {
                    System.out.println();
                    costPrice = sc.nextInt();
                    sc.nextLine();
                    car.setCostPrice(costPrice);
                    System.out.println("Successfully Updated.");
                }
                case 3 -> {
                    System.out.println();
                    rentPricePerDay = sc.nextInt();
                    sc.nextLine();
                    car.setRentPricePerDay(rentPricePerDay);
                    System.out.println("Successfully Updated.");
                }
                case 4 -> {
                    System.out.println();
                    numberPlate = sc.nextLine();
                    car.setNumberPlate(numberPlate);
                    System.out.println("Successfully Updated.");
                }
                case 5 -> {
                    System.out.println();
                    color = sc.nextLine();
                    costPrice = sc.nextInt();
                    sc.nextLine();
                    car.setCostPrice(costPrice);
                    car.setColor(color);
                    System.out.println("Successfully Updated.");
                }
                case 6 -> {
                    System.out.println();
                    costPrice = sc.nextInt();
                    sc.nextLine();
                    rentPricePerDay = sc.nextInt();
                    sc.nextLine();
                    car.setCostPrice(costPrice);
                    car.setRentPricePerDay(rentPricePerDay);
                    System.out.println("Successfully Updated.");
                }
                case 7 -> {
                    System.out.println();
                    color = sc.nextLine();
                    rentPricePerDay = sc.nextInt();
                    sc.nextLine();
                    car.setColor(color);
                    car.setRentPricePerDay(rentPricePerDay);
                    System.out.println("Successfully Updated.");
                }
                case 8 -> {
                    System.out.println();
                    color = sc.nextLine();
                    licensePlateNumber = sc.nextLine();
                    car.setColor(color);
                    car.setNumberPlate(licensePlateNumber);
                    System.out.println("Successfully Updated.");
                }
                case 9 -> {
                    System.out.println();
                    licensePlateNumber = sc.nextLine();
                    rentPricePerDay = sc.nextInt();
                    sc.nextLine();
                    car.setNumberPlate(licensePlateNumber);
                    car.setRentPricePerDay(rentPricePerDay);
                    System.out.println("Successfully Updated.");
                }
                case 10 -> {
                    System.out.println();
                    color = sc.nextLine();
                    rentPricePerDay = sc.nextInt();
                    sc.nextLine();
                    licensePlateNumber = sc.nextLine();
                    car.setColor(color);
                    car.setRentPricePerDay(rentPricePerDay);
                    car.setNumberPlate(licensePlateNumber);
                    System.out.println("Successfully Updated.");
                }
                case 11 -> {
                    System.out.println();
                    color = sc.nextLine();
                    rentPricePerDay = sc.nextInt();
                    sc.nextLine();
                    licensePlateNumber = sc.nextLine();
                    costPrice = sc.nextInt();
                    sc.nextLine();
                    car.setCostPrice(costPrice);
                    car.setColor(color);
                    car.setRentPricePerDay(rentPricePerDay);
                    car.setNumberPlate(licensePlateNumber);
                    System.out.println("Successfully Updated.");
                }
                default -> System.out.println("Sorry Invalid Input...");
            }
        }
    }

    // Method to check if a given license number belongs to a customer within the system
    public boolean checkIfCustomer(String licenseNumber){
        for(Customer customer: allCustomers) {
            if (customer.getLicenseNumber().equals(licenseNumber)) return true;
        }
        return false;
    }

    // Show a car's details
    public void showCar(String licensePlateNumber) {
        Car car = findCar(licensePlateNumber);
        if(car == null) System.out.println("No car found having that license plate number " + licensePlateNumber);
        else System.out.println(car);
    }

    // Method to bind a car to a customer
    public void bindCarToCustomer(Customer customer, Car car){
        customer.getCarsRented().add(car);
        car.setCurrentUser(customer);
        rentedCars.add(car);
        availableCars.remove(car);
    }

    // Method to rent a car(s) to a customer
    public void rentCars(Scanner sc){
        System.out.print("Input customer's license number: ");
        String licenseNumber = sc.nextLine();
        if(!checkIfCustomer(licenseNumber)) {
            System.out.println("Sorry, not a customer.");
            return;
        }
        System.out.print("Number of cars to be rented: ");
        int numberOfCars = sc.nextInt();
        sc.nextLine();
        if(numberOfCars == 1)
            System.out.print("Enter the license plate number of the chosen car: ");
        else
            System.out.println("Enter the license plate number of the chosen cars one after the other below:");
        for (int i = 0; i < numberOfCars; i++) {
            String licensePlateNumber = sc.nextLine();
            if (findCar(licensePlateNumber) != null && availableCars.contains(findCar(licensePlateNumber))) {
                Customer customer = findCustomer(licenseNumber);
                Car car = findCar(licensePlateNumber);
                bindCarToCustomer(customer, car);
                System.out.println("Successfully stored rent details.");
            }else{
                System.out.println("Car is not available.");
            }
        }
    }

}
