//package Helpers;
//
//import Categories.PhonesSubsection.MobilePhones;
//import Categories.PhonesSubsection.PhoneCases;
//
//import java.util.Scanner;
//
//public class PhoneHandler {
//    static Scanner scanner;
//
//    public PhoneHandler(Scanner scanner){
//        PhoneHandler.scanner = scanner;
//    }
//    public static void handlePhoneSubsectionChoice(int subsection, MobilePhones phone, PhoneCases phoneCase) {
//        switch (subsection) {
//            case 1:
//                handlePhoneOptions(phone);
//                break;
//            case 2:
//                handlePhoneCaseOptions(phoneCase);
//                break;
//            default:
//                System.out.println("Invalid subsection");
//        }
//    }
//
//    public static void handlePhoneOptions(MobilePhones phone) {
//        System.out.println("Phones: ");
//        System.out.println("1. Buy a phone");
//        System.out.println("2. Return a phone");
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                buyPhone(phone);
//                break;
//            case 2:
//                returnPhone(phone);
//                break;
//            default:
//                System.out.println("Invalid choice");
//        }
//    }
//
//    public static void handlePhoneCaseOptions(PhoneCases phoneCase) {
//        System.out.println("Phone Cases: ");
//        System.out.println("1. Buy a phone case");
//        System.out.println("2. Return a phone case");
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                buyPhoneCase(phoneCase);
//                break;
//            case 2:
//                returnPhoneCase(phoneCase);
//                break;
//            default:
//                System.out.println("Invalid choice");
//        }
//    }
//
//    public static void buyPhone(MobilePhones phone) {
//        System.out.println("******* Buy a phone *******");
//        System.out.println("Enter quantity to purchase: ");
//        int purchaseQuantity = scanner.nextInt();
//        if (purchaseQuantity <= phone.getQuantityInStore()) {
//            phone.sellProduct(purchaseQuantity);
//            System.out.println(purchaseQuantity + " phones purchased. Phone inventory: " + phone.getQuantityInStore() + " in store, " + phone.getQuantityInWarehouse() + " in warehouse");
//        } else {
//            System.out.println("Error: Not enough phones in store to fulfill your order.");
//        }
//    }
//
//    public static void returnPhone(MobilePhones phone) {
//        System.out.println("******* Return a phone *******");
//        System.out.println("Enter quantity to return: ");
//        int returnQuantity = scanner.nextInt();
//        if (returnQuantity <= phone.getQuantitySold()) {
//            phone.returnProduct(returnQuantity);
//            System.out.println(returnQuantity + " phones returned. Phone inventory: " + phone.getQuantityInStore() + " in store, " + phone.getQuantityInWarehouse() + " in warehouse");
//        } else {
//            System.out.println("Error: You cannot return more phones than you purchased.");
//        }
//    }
//
//    public static void buyPhoneCase(PhoneCases phoneCase) {
//        System.out.println("******* Buy a phone case *******");
//        System.out.println("Enter quantity to purchase: ");
//        int purchaseQuantity = scanner.nextInt();
//        if (purchaseQuantity <= phoneCase.getQuantityInStore()) {
//            phoneCase.sellProduct(purchaseQuantity);
//            System.out.println(purchaseQuantity + " phone cases purchased. Phone case inventory: " + phoneCase.getQuantityInStore() + " in store, " + phoneCase.getQuantityInWarehouse() + " in warehouse");
//        } else {
//            System.out.println("Error: Not enough phone cases in store to fulfill your order.");
//        }
//    }
//
//    public static void returnPhoneCase(PhoneCases phoneCase) {
//        System.out.println("******* Return a phone case *******");
//        System.out.println("Enter quantity to return: ");
//        int returnQuantity = scanner.nextInt();
//        if (returnQuantity <= phoneCase.getQuantitySold()) {
//            phoneCase.returnProduct(returnQuantity);
//            System.out.println(returnQuantity + " phone cases returned. Phone case inventory: " + phoneCase.getQuantityInStore() + " in store, " + phoneCase.getQuantityInWarehouse() + " in warehouse");
//        } else {
//            System.out.println("Error: You cannot return more phone cases than you purchased.");
//        }
//    }
//}
