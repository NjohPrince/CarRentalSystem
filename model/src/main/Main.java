package main;

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

            System.out.println("0. Exit System");

            System.out.println();

            System.out.print("Choose a command option: ");
            option = in.nextInt();
            in.nextLine();

            switch(option) {
                case 1:
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using PJ's Car Rental System!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Option");
                    System.out.println();
            }
        } while(option != 0);
    }
}
