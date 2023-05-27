import Categories.OutdoorSubsection.Chair;
import Categories.OutdoorSubsection.Tent;
//import Categories.PhonesSubsection.MobilePhones;
//import Categories.PhonesSubsection.PhoneCases;
import Categories.Product;
import Helpers.MainHandler;
//import Categories.ComputerElectronicsSubsection.Laptop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        List<Product> products = Product.loadProducts("C:\\Users\\galve\\Documents\\Project\\TechStore\\data\\products.txt");

        List<Tent> tents = new ArrayList<>();
        List<Chair> chairs = new ArrayList<>();

        for (Product product : products) {
            if (product instanceof Tent) {
                tents.add((Tent) product);
            } else if (product instanceof Chair) {
                chairs.add((Chair) product);
            }
        }
        
//        Tent tent = new Tent(1,"Camping Tent", 99.99, false, 25, 10, 0, true);
//        Chair chair = new Chair(1, "Folding Chair", 19.99, true, true, 20, 0, 0);
//
//
//        tents.add(tent);
//        chairs.add(chair);
//
//        MobilePhones phone = new MobilePhones("Iphone 13", 899,false, "Apple", 99,  1000 );
//        PhoneCases phoneCase = new PhoneCases("Iphone 13 Black case", 12.99, true, "Black", 100, 200);
//
//
//
//        Laptop laptop = new Laptop("MacBook Air", 999.99, 500, false, 10, 5);


        System.out.println("********Online store inventory********");
        System.out.println("Which inventory section would you like to check?");
        System.out.println("1. Outdoor");
        System.out.println("2. Phones");
        System.out.println("3. Computer Electronics");
        System.out.println("4. Audio-Video and Photo");
        System.out.println("5. Automobiles");
        System.out.println("6. Video equipment");
        MainHandler mainHandler = new MainHandler(scanner);

        int section = scanner.nextInt();
        mainHandler.handleSectionChoice(section, tents, chairs);// phone, phoneCase, laptop);
        Product.saveProducts(products, "C:\\Users\\galve\\Documents\\Project\\TechStore\\data\\products.txt");



    }
}
