package Helpers;

import Categories.OutdoorSubsection.Chair;
import Categories.OutdoorSubsection.Tent;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class OutdoorHandler {
    public static void handleOutdoorSubsectionChoice(Scanner scanner, int subsection, List<Tent> tents, List<Chair> chairs) {
        switch (subsection) {
            case 1:
                handleTentOptions(scanner, tents);
                break;
            case 2:
                handleChairOptions(scanner, chairs);
                break;
            case 3:
                handleOutdoorFinancialData(tents, chairs);
                break;
            default:
                System.out.println("Invalid subsection");
        }
    }

    public static void handleTentOptions(Scanner scanner, List<Tent> tents) {
        System.out.println("Tents: ");
        System.out.println("1. Create a new tent");
        System.out.println("2. Buy a tent");
        System.out.println("3. Return a tent");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                createNewTent(scanner, tents);
                break;
            case 2:
                buyTent(scanner, tents);
                break;
            case 3:
                returnTent(scanner, tents);
                break;
            // Add other cases here
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void createNewTent(Scanner scanner, List<Tent> tents) {
        System.out.println("******* Create a new tent *******");
        System.out.println("Enter tent name: ");
        String name = scanner.next();
        System.out.println("Enter tent price: ");
        double price = scanner.nextDouble();
        System.out.println("Is the tent discounted? (true/false)");
        boolean discounted = scanner.nextBoolean();
        System.out.println("Is the tent waterproof? (true/false): ");
        boolean waterproof = scanner.nextBoolean();
        System.out.println("Enter quantity of tents in store: ");
        int quantityInStore = scanner.nextInt();
        System.out.println("Enter quantity of tents in warehouse: ");
        int quantityInWarehouse = scanner.nextInt();

        // Generate a new id for the tent
        int id = generateNewId(tents);

        Tent newTent = new Tent(id, name, price, discounted, quantityInStore, quantityInWarehouse, 0, waterproof);
        tents.add(newTent);
        System.out.println("New tent created: " + newTent.getName());
    }

    private static int generateNewId(List<Tent> tents) {
        if (tents.isEmpty()) {
            return 1; // Start with id 1 if the list is empty
        } else {
            int maxId = tents.stream().mapToInt(Tent::getId).max().orElse(0);
            return maxId + 1; // Generate a new id by incrementing the maximum id in the list
        }
    }


    // Buy Tent method
    public static void buyTent(Scanner scanner, List<Tent> tents) {
        System.out.println("******* Buy a tent *******");
        for (int i = 0; i < tents.size(); i++) {
            System.out.println((i + 1) + ". " + tents.get(i).getName() + ", Price: " + tents.get(i).getPrice() + ", Discounted: " + tents.get(i).getIsDiscounted() + ", Waterproof: " + tents.get(i).isWaterproof() + " Quantity in store: " + tents.get(i).getQuantityInStore());
        }
        System.out.println("Enter the number of the tent you want to purchase: ");
        int tentNumber = scanner.nextInt() - 1;  // we subtract 1 because array indices start at 0
        System.out.println("Enter quantity to purchase: ");
        int purchaseQuantity = scanner.nextInt();
        if (purchaseQuantity <= tents.get(tentNumber).getQuantityInStore()) {
            tents.get(tentNumber).sellProduct(purchaseQuantity);
            System.out.println(purchaseQuantity + " tents purchased. Tent inventory: " + tents.get(tentNumber).getQuantityInStore() + " in store, " + tents.get(tentNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: Not enough tents in store to fulfill your order.");
        }
    }

    // Return Tent method
    public static void returnTent(Scanner scanner, List<Tent> tents) {
        System.out.println("******* Return a tent *******");
        for (int i = 0; i < tents.size(); i++) {
            System.out.println((i + 1) + ". " + tents.get(i).getName() + ", Quantity sold: " + tents.get(i).getQuantitySold());
        }
        System.out.println("Enter the number of the tent you want to return: ");
        int tentNumber = scanner.nextInt() - 1;  // we subtract 1 because array indices start at 0
        System.out.println("Enter quantity to return: ");
        int returnQuantity = scanner.nextInt();
        if (returnQuantity <= tents.get(tentNumber).getQuantitySold()) {
            tents.get(tentNumber).returnProduct(returnQuantity);
            System.out.println(returnQuantity + " tents returned. Tent inventory: " + tents.get(tentNumber).getQuantityInStore() + " in store, " + tents.get(tentNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: You cannot return more tents than you purchased.");
        }
    }

    public static void buyChair(Scanner scanner, List<Chair> chairs) {
        System.out.println("******* Buy a chair *******");
        for (int i = 0; i < chairs.size(); i++) {
            System.out.println((i + 1) + ". " + chairs.get(i).getName() + ", Price: " + chairs.get(i).getPrice() + ", Discounted: " + chairs.get(i).getIsDiscounted() + " Foldable: " + chairs.get(i).isFoldable() + " , Quantity in store: " + chairs.get(i).getQuantityInStore());
        }
        System.out.println("Enter the number of the chair you want to purchase: ");
        int chairNumber = scanner.nextInt() - 1;  // we subtract 1 because array indices start at 0
        System.out.println("Enter quantity to purchase: ");
        int purchaseQuantity = scanner.nextInt();
        if (purchaseQuantity <= chairs.get(chairNumber).getQuantityInStore()) {
            chairs.get(chairNumber).sellProduct(purchaseQuantity);
            System.out.println(purchaseQuantity + " chairs purchased. Chair inventory: " + chairs.get(chairNumber).getQuantityInStore() + " in store, " + chairs.get(chairNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: Not enough chairs in store to fulfill your order.");
        }
    }

    public static void returnChair(Scanner scanner, List<Chair> chairs) {
        System.out.println("******* Return a chair *******");
        for (int i = 0; i < chairs.size(); i++) {
            System.out.println((i + 1) + ". " + chairs.get(i).getName() + ", Quantity sold: " + chairs.get(i).getQuantitySold());
        }
        System.out.println("Enter the number of the chair you want to return: ");
        int chairNumber = scanner.nextInt() - 1;  // we subtract 1 because array indices start at 0
        System.out.println("Enter quantity to return: ");
        int returnQuantity = scanner.nextInt();
        if (returnQuantity <= chairs.get(chairNumber).getQuantitySold()) {
            chairs.get(chairNumber).returnProduct(returnQuantity);
            System.out.println(returnQuantity + " chairs returned. Chair inventory: " + chairs.get(chairNumber).getQuantityInStore() + " in store, " + chairs.get(chairNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: You cannot return more chairs than you purchased.");
        }
    }
    public static void handleChairOptions(Scanner scanner, List<Chair> chairs) {
        System.out.println("Chairs: ");
        System.out.println("1. Create a new chair");
        System.out.println("2. Buy a chair");
        System.out.println("3. Return a chair");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                createNewChair(scanner, chairs);
                break;
            case 2:
                buyChair(scanner, chairs);
                break;
            case 3:
                returnChair(scanner, chairs);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void createNewChair(Scanner scanner, List<Chair> chairs) {
        System.out.println("******* Create a new chair *******");
        System.out.println("Enter chair name: ");
        String name = scanner.next();
        System.out.println("Enter chair price: ");
        double price = scanner.nextDouble();
        System.out.println("Is the chair foldable? (true/false)");
        boolean foldable = scanner.nextBoolean();
        System.out.println("Is the chair discounted? (true/false)");
        boolean discounted = scanner.nextBoolean();
        System.out.println("Enter quantity of chairs in store: ");
        int quantityInStore = scanner.nextInt();
        System.out.println("Enter quantity of chairs in warehouse: ");
        int quantityInWarehouse = scanner.nextInt();

        // Generate a unique id for the new chair
        int id = generateUniqueId(chairs);

        Chair newChair = new Chair(id, name, price, foldable, discounted, quantityInStore, quantityInWarehouse, 0);
        chairs.add(newChair);
        System.out.println("New chair created: " + newChair.getName());
    }

    private static int generateUniqueId(List<Chair> chairs) {
        int id = chairs.size() + 1;  // Assign a unique id based on the current size of the chairs list
        return id;
    }


    public static void handleOutdoorFinancialData(List<Tent> tents, List<Chair> chairs) {
        System.out.println("********Outdoor Section Financial Data********");
        System.out.println("Tent Financial Data:");
        System.out.println("Total Tents Sold: " + getTotalSoldTents(tents));
        System.out.println("Total Tent Revenue: $" + getTotalRevenueTents(tents));
        System.out.println("Chair Financial Data:");
        System.out.println("Total Chairs Sold: " + getTotalSoldChairs(chairs));
        System.out.println("Total Chair Revenue: $" + getTotalRevenueChairs(chairs));
    }

    private static int getTotalSoldTents(List<Tent> tents) {
        int totalSoldTents = 0;
        for (Tent tent : tents) {
            totalSoldTents += tent.getQuantitySold();
        }
        return totalSoldTents;
    }

    private static double getTotalRevenueTents(List<Tent> tents) {
        double totalRevenueTents = 0.0;
        for (Tent tent : tents) {
            totalRevenueTents += tent.getPrice() * tent.getQuantitySold();
        }
        return totalRevenueTents;
    }

    private static int getTotalSoldChairs(List<Chair> chairs) {
        int totalSoldChairs = 0;
        for (Chair chair : chairs) {
            totalSoldChairs += chair.getQuantitySold();
        }
        return totalSoldChairs;
    }

    private static double getTotalRevenueChairs(List<Chair> chairs) {
        double totalRevenueChairs = 0.0;
        for (Chair chair : chairs) {
            totalRevenueChairs += chair.getPrice() * chair.getQuantitySold();
        }
        return totalRevenueChairs;
    }
}


