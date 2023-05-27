package Helpers;

import Categories.OutdoorSubsection.Chair;
import Categories.OutdoorSubsection.Tent;
//import Categories.PhonesSubsection.MobilePhones;
//import Categories.PhonesSubsection.PhoneCases;
//import Categories.ComputerElectronicsSubsection.Laptop;

import java.util.List;
import java.util.Scanner;

//import static Helpers.PhoneHandler.handlePhoneSubsectionChoice;

public class MainHandler {
    private final Scanner scanner;
  //  private ComputerHandler computerHandler;


    public MainHandler(Scanner scanner) {
        this.scanner = scanner;
        //this.computerHandler = new ComputerHandler(scanner);

    }

    public void handleSectionChoice(int section, List<Tent> tents, List<Chair> chairs){// MobilePhones phone, PhoneCases phoneCase, Laptop laptop) {
        int subsection;
        if (section == 1) {
            System.out.println("Which subsection would you like to check? ");
            System.out.println("1. Tents");
            System.out.println("2. Chairs");
            System.out.println("3. Financial data");
            subsection = scanner.nextInt();
            OutdoorHandler.handleOutdoorSubsectionChoice(scanner, subsection, tents, chairs);
            //            case 2:
//                System.out.println("Which subsection would you like to check? ");
//                System.out.println("1. Mobile Phones");
//                System.out.println("2. Phone Cases");
//                subsection = scanner.nextInt();
//                handlePhoneSubsectionChoice(subsection, phone, phoneCase);
//                break;
//            case 3:
//                System.out.println("Which subsection would you like to check? ");
//                System.out.println("1. Laptops");
//                subsection = scanner.nextInt();
//                computerHandler.handleComputerElectronicsSubsectionChoice(subsection, laptop);
//                break;

            // Add other cases here
        } else {
            System.out.println("Invalid section");
        }
    }
}
