import Categories.OutdoorSubsection.Chair;
import Categories.OutdoorSubsection.Tent;
import Categories.PhonesSubsection.MobilePhones;
import Categories.PhonesSubsection.PhoneCases;
import Categories.Product;
import Helpers.MainHandler;
import Categories.ComputerElectronicsSubsection.Laptop;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Product> products = Product.loadProducts("/data/products.txt");

        List<Tent> tents = new ArrayList<>();
        List<Chair> chairs = new ArrayList<>();
        List<MobilePhones> phones = new ArrayList<>();
        List<PhoneCases> phoneCases = new ArrayList<>();
        List<Laptop> laptops = new ArrayList<>();

        for (Product product : products) {
            if (product instanceof Tent) {
                tents.add((Tent) product);
            } else if (product instanceof Chair) {
                chairs.add((Chair) product);
            } else if (product instanceof MobilePhones) {
                phones.add((MobilePhones) product);
            } else if (product instanceof PhoneCases) {
                phoneCases.add((PhoneCases) product);
            } else if (product instanceof Laptop) {
                laptops.add((Laptop) product);
            }
        }



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
        mainHandler.handleSectionChoice(section, tents, chairs, phones, phoneCases, laptops);
        Product.saveProducts(products, "/data/products.txt");



    }
}
