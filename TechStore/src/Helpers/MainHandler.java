package Helpers;

import Categories.ComputerElectronicsSubsection.Laptop;
import Categories.OutdoorSubsection.Chair;
import Categories.OutdoorSubsection.Tent;
import Categories.PhonesSubsection.MobilePhones;
import Categories.PhonesSubsection.PhoneCases;


import java.util.List;
import java.util.Scanner;

import static Helpers.PhoneHandler.handlePhoneSubsectionChoice;


public class MainHandler {
    private final Scanner scanner;


    public MainHandler(Scanner scanner) {
        this.scanner = scanner;

    }

    public void handleSectionChoice(int section, List<Tent> tents, List<Chair> chairs, List<MobilePhones> phones, List<PhoneCases> phoneCases, List<Laptop> laptops) {
        int subsection;
        switch (section) {
            case 1:
                System.out.println("Which subsection would you like to check? ");
                System.out.println("1. Tents");
                System.out.println("2. Chairs");
                System.out.println("3. Financial data");
                subsection = scanner.nextInt();
                OutdoorHandler.handleOutdoorSubsectionChoice(scanner, subsection, tents, chairs);
                break;
            case 2:
                System.out.println("Which subsection would you like to check? ");
                System.out.println("1. Mobile Phones");
                System.out.println("2. Phone Cases");
                subsection = scanner.nextInt();
                handlePhoneSubsectionChoice(scanner, subsection, phones, phoneCases);
                break;
            case 3:
                System.out.println("Which subsection would you like to check? ");
                System.out.println("1. Laptops");
                subsection = scanner.nextInt();
                ComputerHandler.handleComputerElectronicsSubsectionChoice(scanner, subsection, laptops);
                break;
            default:
                System.out.println("Invalid section");
        }

    }
}
