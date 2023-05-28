package Helpers;

import Categories.PhonesSubsection.MobilePhones;
import Categories.PhonesSubsection.PhoneCases;
import java.util.List;

import java.util.Scanner;

public class PhoneHandler {

    public static void handlePhoneSubsectionChoice(Scanner scanner, int subsection, List<MobilePhones> phones, List<PhoneCases> phoneCases) {
        switch (subsection) {
            case 1:
                handlePhoneOptions(scanner,phones);
                break;
            case 2:
                handlePhoneCaseOptions(scanner, phoneCases);
                break;
            case 3:
                handlePhoneFinancialData(phones, phoneCases);
            default:
                System.out.println("Invalid subsection");
        }
    }

    public static void handlePhoneOptions(Scanner scanner,List<MobilePhones> phones) {
        System.out.println("Phones: ");
        System.out.println("1. Create a new phone");
        System.out.println("2. Buy a phone");
        System.out.println("3. Return a phone");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                createNewPhone(scanner, phones);
            case 2:
                buyPhone(scanner, phones);
                break;
            case 3:
                returnPhone(scanner, phones);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    private static void createNewPhone(Scanner scanner, List<MobilePhones> phones) {
        System.out.println("******* Create a new phone *******");
        System.out.println("Enter phone name: ");
        String name = scanner.next();
        System.out.println("Enter phone price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter phone brand: ");
        String brand = scanner.next();
        System.out.println("Is the phone discounted? (true/false)");
        boolean discounted = scanner.nextBoolean();
        System.out.println("Enter quantity of phones in store: ");
        int quantityInStore = scanner.nextInt();
        System.out.println("Enter quantity of phones in warehouse: ");
        int quantityInWarehouse = scanner.nextInt();

        int id = generateNewIdPhone(phones);

        MobilePhones newPhone = new MobilePhones(id, name, price, discounted, brand, quantityInStore, quantityInWarehouse, 0);
        phones.add(newPhone);
        System.out.println("New phone created: " + newPhone.getName());
    }

    private static int generateNewIdPhone(List<MobilePhones> phones) {
        if (phones.isEmpty()) {
            return 1; // Start with id 1 if the list is empty
        } else {
            int maxId = phones.stream().mapToInt(MobilePhones::getId).max().orElse(0);
            return maxId + 1; // Generate a new id by incrementing the maximum id in the list
        }
    }


    public static void handlePhoneCaseOptions(Scanner scanner, List<PhoneCases> phoneCases) {
        System.out.println("Phone Cases: ");
        System.out.println("1. Create a new phone case");
        System.out.println("2. Buy a phone case");
        System.out.println("3. Return a phone case");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                createNewPhoneCase(scanner, phoneCases);
                break;
            case 2:
                buyPhoneCase(scanner, phoneCases);
                break;
            case 3:
                returnPhoneCase(scanner, phoneCases);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void buyPhone(Scanner scanner, List<MobilePhones> phones) {
        System.out.println("******* Buy a phone *******");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println((i + 1) + ". " + phones.get(i).getName() + ", Price: " + phones.get(i).getPrice() +
                    ", Brand: " + phones.get(i).getBrand() + ", Quantity in store: " + phones.get(i).getQuantityInStore());
        }
        System.out.println("Enter the number of the phone you want to purchase: ");
        int phoneNumber = scanner.nextInt() - 1;
        System.out.println("Enter quantity to purchase: ");
        int purchaseQuantity = scanner.nextInt();
        if (purchaseQuantity <= phones.get(phoneNumber).getQuantityInStore()) {
            phones.get(phoneNumber).sellProduct(purchaseQuantity);
            System.out.println(purchaseQuantity + " phones purchased. Phone inventory: " +
                    phones.get(phoneNumber).getQuantityInStore() + " in store, " +
                    phones.get(phoneNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: Not enough phones in store to fulfill your order.");
        }
    }

    private static void returnPhone(Scanner scanner, List<MobilePhones> phones) {
        System.out.println("******* Return a phone *******");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println((i + 1) + ". " + phones.get(i).getName() + ", Quantity sold: " + phones.get(i).getQuantitySold());
        }
        System.out.println("Enter the number of the phone you want to return: ");
        int phoneNumber = scanner.nextInt() - 1;
        System.out.println("Enter quantity to return: ");
        int returnQuantity = scanner.nextInt();
        if (returnQuantity <= phones.get(phoneNumber).getQuantitySold()) {
            phones.get(phoneNumber).returnProduct(returnQuantity);
            System.out.println(returnQuantity + " phones returned. Phone inventory: " +
                    phones.get(phoneNumber).getQuantityInStore() + " in store, " +
                    phones.get(phoneNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: You cannot return more phones than you purchased.");
        }
    }


    private static void createNewPhoneCase(Scanner scanner, List<PhoneCases> phoneCases) {
        System.out.println("******* Create a new phone case *******");
        System.out.println("Enter phone case name: ");
        String name = scanner.next();
        System.out.println("Enter phone case price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter phone case color: ");
        String color = scanner.next();
        System.out.println("Is the phone case discounted? (true/false)");
        boolean discounted = scanner.nextBoolean();
        System.out.println("Enter quantity of phone cases in store: ");
        int quantityInStore = scanner.nextInt();
        System.out.println("Enter quantity of phone cases in warehouse: ");
        int quantityInWarehouse = scanner.nextInt();

        int id = generateNewIdPhoneCase(phoneCases);

        PhoneCases newPhoneCase = new PhoneCases(id, name, price, discounted, color, quantityInStore, quantityInWarehouse, 0);
        System.out.println("New phone case created: " + newPhoneCase.getName());
    }
    private static int generateNewIdPhoneCase(List<PhoneCases> phoneCases) {
        if (phoneCases.isEmpty()) {
            return 1;
        } else {
            int maxId = phoneCases.stream().mapToInt(PhoneCases::getId).max().orElse(0);
            return maxId + 1;
        }
    }

    private static void buyPhoneCase(Scanner scanner, List<PhoneCases> phoneCases) {
        System.out.println("******* Buy a phone case *******");
        for (int i = 0; i < phoneCases.size(); i++) {
            System.out.println((i + 1) + ". " + phoneCases.get(i).getName() + ", Price: " + phoneCases.get(i).getPrice() +
                    ", Color: " + phoneCases.get(i).getColor() + ", Quantity in store: " + phoneCases.get(i).getQuantityInStore());
        }
        System.out.println("Enter the number of the phone case you want to purchase: ");
        int phoneCaseNumber = scanner.nextInt() - 1;
        System.out.println("Enter quantity to purchase: ");
        int purchaseQuantity = scanner.nextInt();
        if (purchaseQuantity <= phoneCases.get(phoneCaseNumber).getQuantityInStore()) {
            phoneCases.get(phoneCaseNumber).sellProduct(purchaseQuantity);
            System.out.println(purchaseQuantity + " phone cases purchased. Phone case inventory: " +
                    phoneCases.get(phoneCaseNumber).getQuantityInStore() + " in store, " +
                    phoneCases.get(phoneCaseNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: Not enough phone cases in store to fulfill your order.");
        }
    }

    private static void returnPhoneCase(Scanner scanner, List<PhoneCases> phoneCases) {
        System.out.println("******* Return a phone case *******");
        for (int i = 0; i < phoneCases.size(); i++) {
            System.out.println((i + 1) + ". " + phoneCases.get(i).getName() + ", Quantity sold: " + phoneCases.get(i).getQuantitySold());
        }
        System.out.println("Enter the number of the phone case you want to return: ");
        int phoneCaseNumber = scanner.nextInt() - 1;
        System.out.println("Enter quantity to return: ");
        int returnQuantity = scanner.nextInt();
        if (returnQuantity <= phoneCases.get(phoneCaseNumber).getQuantitySold()) {
            phoneCases.get(phoneCaseNumber).returnProduct(returnQuantity);
            System.out.println(returnQuantity + " phone cases returned. Phone case inventory: " +
                    phoneCases.get(phoneCaseNumber).getQuantityInStore() + " in store, " +
                    phoneCases.get(phoneCaseNumber).getQuantityInWarehouse() + " in warehouse");
        } else {
            System.out.println("Error: You cannot return more phone cases than you purchased.");
        }
    }
    public static void handlePhoneFinancialData(List<MobilePhones> phones, List<PhoneCases> phoneCases) {
        System.out.println("********Phone Subsection Financial Data********");
        System.out.println("Mobile Phones Financial Data:");
        System.out.println("Total Mobile Phones Sold: " + getTotalSoldMobilePhones(phones));
        System.out.println("Total Mobile Phones Revenue: $" + getTotalRevenueMobilePhones(phones));
        System.out.println("Phone Cases Financial Data:");
        System.out.println("Total Phone Cases Sold: " + getTotalSoldPhoneCases(phoneCases));
        System.out.println("Total Phone Cases Revenue: $" + getTotalRevenuePhoneCases(phoneCases));
    }

    private static int getTotalSoldMobilePhones(List<MobilePhones> phones) {
        int totalSoldMobilePhones = 0;
        for (MobilePhones phone : phones) {
            totalSoldMobilePhones += phone.getQuantitySold();
        }
        return totalSoldMobilePhones;
    }

    private static double getTotalRevenueMobilePhones(List<MobilePhones> phones) {
        double totalRevenueMobilePhones = 0.0;
        for (MobilePhones phone : phones) {
            totalRevenueMobilePhones += phone.getPrice() * phone.getQuantitySold();
        }
        return totalRevenueMobilePhones;
    }

    private static int getTotalSoldPhoneCases(List<PhoneCases> phoneCases) {
        int totalSoldPhoneCases = 0;
        for (PhoneCases phoneCase : phoneCases) {
            totalSoldPhoneCases += phoneCase.getQuantitySold();
        }
        return totalSoldPhoneCases;
    }

    private static double getTotalRevenuePhoneCases(List<PhoneCases> phoneCases) {
        double totalRevenuePhoneCases = 0.0;
        for (PhoneCases phoneCase : phoneCases) {
            totalRevenuePhoneCases += phoneCase.getPrice() * phoneCase.getQuantitySold();
        }
        return totalRevenuePhoneCases;
    }

}
