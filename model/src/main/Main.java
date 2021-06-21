package main;

import main.controller.Controller;
import main.model.Car;
import main.model.Customer;

import java.util.Scanner;

/**
 * @author ProgrammingGeek - Njoh Noh Prince Junior
 * @since 21-06-2021
 *
 * Car Rent Management System - Demonstrating OOP in Java Programming languages
 */

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();

        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("**                                                                   **");
        System.out.println("**   WELCOME TO PJ's CAR/CUSTOMER MANAGEMENT AND CAR RENTAL SYSTEM   **");
        System.out.println("**                                                                   **");
        System.out.println("***********************************************************************");
        System.out.println("***********************************************************************");

        System.out.println();

        int option;
        Scanner in = new Scanner(System.in);
        do {

            // Displaying a list of available operations/system manipulations.
            System.out.println("\nAvailable Options");
            System.out.println("-----------------");

            System.out.println("\nDOCUMENTATION\n");
            System.out.println("  1. View Documentation");

            System.out.println("\nMANAGE CARS\n");

            System.out.println("  2. Add a new car");
            System.out.println("  3. View all cars");
            System.out.println("  4. Check available cars for rent");
            System.out.println("  5. Delete a car");
            System.out.println("  6. Modify a car's details");
            System.out.println("  7. Rent car(s)");
            System.out.println("  8 Show a car's details");

            System.out.println("\nMANAGE CUSTOMERS\n");

            System.out.println("9. Add a new customer");
            System.out.println("10. View all customers");
            System.out.println("11. View a customer's rent details");
            System.out.println("12. Clear a customer's rent");
            System.out.println("13. Remove customer from system");
            System.out.println("14. Show all rents");
            System.out.println("15. Show a customer's details");

            System.out.println("0. Terminate/Exit System");

            System.out.println();

            System.out.print("Choose a command option: ");
            option = in.nextInt();
            in.nextLine();

            // Action to be done - determined by the 'option' the user selects.
            switch (option) {
                case 1 -> {
                    break;
                }
                case 2 -> {
                    System.out.println("\nEnter car details:");
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Brand: ");
                    String brand = in.nextLine();
                    System.out.print("License plate number: ");
                    String plateNumber = in.nextLine();
                    System.out.print("Rent price per day: ");
                    int pricePerDay = in.nextInt();
                    in.nextLine();
                    System.out.print("Cost price: ");
                    int costPrice = in.nextInt();
                    in.nextLine();
                    System.out.print("Color: ");
                    String color = in.nextLine();
                    Car car_check = controller.findCar(plateNumber);
                    if (car_check == null) {
                        controller.addNewCar(name, brand, plateNumber, pricePerDay, costPrice, color);
                        System.out.println("\nSuccessfully added new car");
                    } else {
                        System.out.println("\nSorry car already exist with license plate number " + plateNumber);
                    }
                }
                case 3 -> {

                    break;
                }
                case 4 -> {

                    break;
                }
                case 9 -> {
                    System.out.println("Enter customer details:");
                    System.out.print("Name: ");
                    String customerName = in.nextLine();
                    System.out.print("Age: ");
                    int customerAge = in.nextInt();
                    in.nextLine();
                    System.out.print("License number: ");
                    String licenseNumber = in.nextLine();
                    System.out.print("N_ID number: ");
                    String nationalIDNumber = in.nextLine();
                    Customer customer_check = controller.findCustomer(licenseNumber, nationalIDNumber);
                    if (customer_check == null) {
                        controller.addNewCustomer(customerName, customerAge, licenseNumber, nationalIDNumber);
                        System.out.println("\nSuccessfully added new customer");
                    } else {
                        System.out.println("\nSorry customer already exist with license number " + licenseNumber);
                    }
                }
                case 0 -> {
                    System.out.println();
                    System.out.println("Thank you for using PJ's Car Rental System!");
                }
                default -> {
                    System.out.println();
                    System.out.println("Invalid Option... Please select a valid operation from the list provided!");
                    System.out.println();
                }
            }
        } while(option != 0);
    }
}
