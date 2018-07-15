package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChooserFactory simpleFactory = new ChooserFactory();
        AbstractChooser standartChooser = simpleFactory.createChooser("StandartChooser");
        System.out.println(standartChooser + " is ready to choose the option.");
        Option option1 = standartChooser.chooseOption();
        System.out.println(option1 + " was choosed");
        AbstractChooser catchingChooser = simpleFactory.createChooser("CatchingChooser");
        AbstractChooser rouletteChooser = simpleFactory.createChooser("RouletteChooser");
        System.out.println(rouletteChooser + " is ready to choose the option.");
        Option option2 = rouletteChooser.chooseOption();
        System.out.println(option2 + " was choosen by roulette algorithm");
        roulleteTesting();
        System.out.println("\n Enter the class you want to load: ");
        Scanner scanner = new Scanner(System.in);
        String classname = scanner.nextLine();
        scanner.close();
        AbstractChooser scannedChooser = simpleFactory.createChooser(classname);
        if (scannedChooser != null){
            System.out.println(scannedChooser + " is ready to choose the option.");
            Option option3 = scannedChooser.chooseOption();
            System.out.println(option3 + " was choosed");
        }
        System.out.println("Finished");
    }


    static void roulleteTesting() {
        ChooserFactory testFactory = new ChooserFactory();
        AbstractChooser testChooser = testFactory.createChooser("RouletteChooser");
        System.out.println("Available options: " + testChooser.getOptions());
        List<Option> givenData = new ArrayList<>();
        double sumUtilities = 0;
        for (Option option2 : testChooser.getOptions()) {
            sumUtilities += option2.getUtility();
            givenData.add(new Option(option2.getName(), 1));
        }

        for (int i = 0; i < sumUtilities; i++) {
            Option testOption = testChooser.chooseOption();
            for (Option option2 : givenData) {
                if (option2.getName() == testOption.getName()) {
                    option2.setUtility(option2.getUtility() + 1);
                    break;
                }
            }
        }
        System.out.println("Data " + givenData);

    }
}
