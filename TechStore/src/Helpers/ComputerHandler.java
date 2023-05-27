//package Helpers;
//
//import Categories.ComputerElectronicsSubsection.Laptop;
//
//import java.util.Scanner;
//
//public class ComputerHandler {
//    private Scanner scanner;
//
//    public ComputerHandler(Scanner scanner) {
//        this.scanner = scanner;
//    }
//
//    public void handleComputerElectronicsSubsectionChoice(int subsection, Laptop laptop) {
//        switch (subsection) {
//            case 1:
//                handleLaptopOptions(laptop);
//                break;
//            // Add other computer electronics subsection cases here
//            default:
//                System.out.println("Invalid subsection");
//        }
//    }
//
//    private void handleLaptopOptions(Laptop laptop) {
//        System.out.println("Laptops: ");
//        System.out.println("1. Create a new laptop");
//        System.out.println("2. Buy a laptop");
//        System.out.println("3. Return a laptop");
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                createNewLaptop();
//                break;
//            case 2:
//                buyLaptop(laptop);
//                break;
//            case 3:
//                returnLaptop(laptop);
//                break;
//            // Add other laptop options here
//            default:
//                System.out.println("Invalid choice");
//        }
//    }
//
//    private void createNewLaptop() {
//        System.out.println("******* Create a new laptop *******");
//        System.out.println("Enter laptop name: ");
//        String name = scanner.next();
//        System.out.println("Enter laptop price: ");
//        double price = scanner.nextDouble();
//        System.out.println("Enter storage space (in GB): ");
//        int storageSpace = scanner.nextInt();
//        System.out.println("Is the laptop discounted? (true/false)");
//        boolean discounted = scanner.nextBoolean();
//        System.out.println("Enter quantity of laptops in store: ");
//        int quantityInStore = scanner.nextInt();
//        System.out.println("Enter quantity of laptops in warehouse: ");
//        int quantityInWarehouse = scanner.nextInt();
//        Laptop newLaptop = new Laptop(name, price, storageSpace, discounted, quantityInStore, quantityInWarehouse);
//        System.out.println("New laptop created: " + newLaptop.getName());
//    }
//
//    private void buyLaptop(Laptop laptop) {
//        System.out.println("******* Buy a laptop *******");
//        System.out.println("Enter quantity to purchase: ");
//        int purchaseQuantity = scanner.nextInt();
//        if (purchaseQuantity <= laptop.getQuantityInStore()) {
//            laptop.sellProduct(purchaseQuantity);
//            System.out.println(purchaseQuantity + " laptops purchased. Laptop inventory: " + laptop.getQuantityInStore() + " in store, " + laptop.getQuantityInWarehouse() + " in warehouse");
//        } else {
//            System.out.println("Error: Not enough laptops in store to fulfill your order.");
//        }
//    }
//
//    private void returnLaptop(Laptop laptop) {
//        System.out.println("******* Return a laptop *******");
//        System.out.println("Enter quantity to return: ");
//        int returnQuantity = scanner.nextInt();
//        if (returnQuantity <= laptop.getQuantitySold()) {
//            laptop.returnProduct(returnQuantity);
//            System.out.println(returnQuantity + " laptops returned. Laptop inventory: " + laptop.getQuantityInStore() + " in store, " + laptop.getQuantityInWarehouse() + " in warehouse");
//        } else {
//            System.out.println("Error: You cannot return more laptops than you purchased.");
//        }
//    }
//}
