package Helpers;

import Categories.ComputerElectronicsSubsection.Laptop;

import java.util.List;
import java.util.Scanner;

public class ComputerHandler {
    private Scanner scanner;

    public static void handleComputerElectronicsSubsectionChoice(Scanner scanner, int subsection, List<Laptop> laptops) {
        switch (subsection) {
            case 1:
                handleLaptopOptions(scanner, laptops);
                break;
            case 2:
                handleLaptopFinancialData(laptops);
            default:
                System.out.println("Invalid subsection");
        }
    }

    private static void handleLaptopOptions(Scanner scanner, List<Laptop> laptops) {
        System.out.println("Laptops: ");
        System.out.println("1. Create a new laptop");
        System.out.println("2. Buy a laptop");
        System.out.println("3. Return a laptop");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                createNewLaptop(scanner, laptops);
                break;
            case 2:
                buyLaptop(scanner, laptops);
                break;
            case 3:
                returnLaptop(scanner, laptops);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void createNewLaptop(Scanner scanner, List<Laptop> laptops) {
        System.out.println("******* Create a new laptop *******");
        System.out.println("Enter laptop name: ");
        String name = scanner.next();
        System.out.println("Enter laptop price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter storage space (in GB): ");
        int storageSpace = scanner.nextInt();
        System.out.println("Is the laptop discounted? (true/false)");
        boolean discounted = scanner.nextBoolean();
        System.out.println("Enter quantity of laptops in store: ");
        int quantityInStore = scanner.nextInt();
        System.out.println("Enter quantity of laptops in warehouse: ");
        int quantityInWarehouse = scanner.nextInt();

        int id = generateNewId(laptops);

        Laptop newLaptop = new Laptop(id, name, price, storageSpace, discounted, quantityInStore, quantityInWarehouse, 0);
        System.out.println("New laptop created: " + newLaptop.getName());
    }
    private static int generateNewId(List<Laptop> laptops) {
        if (laptops.isEmpty()) {
            return 1; // Start with id 1 if the list is empty
        } else {
            int maxId = laptops.stream().mapToInt(Laptop::getId).max().orElse(0);
            return maxId + 1; // Generate a new id by incrementing the maximum id in the list
        }
    }

    private static void buyLaptop(Scanner scanner, List<Laptop> laptops) {
        System.out.println("******* Buy a laptop *******");
        for (int i = 0; i < laptops.size(); i++){
            System.out.println(((i + 1) + ". " + laptops.get(i).getName() + ", Price: " + laptops.get(i).getPrice() + ", Storage space: " + laptops.get(i).getStorageSpace() +
                    ", Discounted: " + laptops.get(i).getIsDiscounted() + ", Quantity in store: " + laptops.get(i).getQuantityInStore() + ", Quantity in warehouse: " + laptops.get(i).getQuantityInWarehouse()));
        }
        System.out.println("Enter the number of the laptop you want to purchase:  ");
        int laptopNumber = scanner.nextInt() - 1;
        System.out.println("Enter quantity to purchase: ");
        int purchaseQuantity = scanner.nextInt();
        if (purchaseQuantity <= laptops.get(laptopNumber).getQuantityInStore()) {
            laptops.get(laptopNumber).sellProduct(purchaseQuantity);
            System.out.println(purchaseQuantity + " laptops purchased. Laptop inventory: " + laptops.get(laptopNumber).getQuantityInStore() + " in store, " + laptops.get(laptopNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: Not enough laptops in store to fulfill your order.");
        }
    }

    private static void returnLaptop(Scanner scanner, List<Laptop> laptops) {
        System.out.println("******* Return a laptop *******");
        for (int i = 0; i < laptops.size(); i++) {
            System.out.println((i + 1) + ". " + laptops.get(i).getName() + ", Quantity sold: " + laptops.get(i).getQuantitySold());
        }
        System.out.println("Enter the number of the laptops you want to return: ");
        int laptopNumber = scanner.nextInt() - 1;
        System.out.println("Enter quantity to return: ");
        int returnQuantity = scanner.nextInt();
        if (returnQuantity <= laptops.get(laptopNumber).getQuantitySold()) {
            laptops.get(laptopNumber).returnProduct(returnQuantity);
            System.out.println(returnQuantity + " laptops returned. Laptop inventory: " + laptops.get(laptopNumber).getQuantityInStore() + " in store, " + laptops.get(laptopNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: You cannot return more laptops than you purchased.");
        }
    }

    private static void handleLaptopFinancialData(List<Laptop> laptops) {
        System.out.println("********Computer Electronics Section Financial Data********");
        System.out.println("Laptop Financial Data:");
        System.out.println("Total Laptops Sold: " + getTotalSoldLaptops(laptops));
        System.out.println("Total Laptop Revenue: $" + getTotalRevenueLaptops(laptops));
    }

    private static int getTotalSoldLaptops(List<Laptop> laptops) {
        int totalSoldLaptops = 0;
        for (Laptop laptop : laptops) {
            totalSoldLaptops += laptop.getQuantitySold();
        }
        return totalSoldLaptops;
    }

    private static double getTotalRevenueLaptops(List<Laptop> laptops) {
        double totalRevenueLaptops = 0.0;
        for (Laptop laptop : laptops) {
            totalRevenueLaptops += laptop.getPrice() * laptop.getQuantitySold();
        }
        return totalRevenueLaptops;
    }
}
