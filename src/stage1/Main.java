package stage1;
import stage2.ResourceCalculator;
import stage3.ResourceCheckResult;
import stage3.ResourceChecker;
import stage3.Resources;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting preparation for the space journey");
        checkHealthAndApproveTravelers();
        Resources needed = calculateRequiredResources();
        Resources available = collectResources();
        if (!checkResources(needed, available)) {
            return ;
        }
        processPaymentForJourney();
        countdown();
        startSpaceJourney();
    }

    static void pause() {
        try {
            Thread.sleep(2000); }
        catch (InterruptedException e) {
            System.err.println("This is weird how did this happen");
        }
    }

    static void OK() {
        System.out.println("OK");
    }

    static void checkHealthAndApproveTravelers() {
        System.out.println("Health checking of the travelers and approval for the journey...");
        pause();
        OK();
    }

    static void processPaymentForJourney() {
        System.out.println("Payment for the space journey…");
        pause();
        OK();
    }

    static Resources calculateRequiredResources() {
        System.out.println("Calculation of required resources for the travelers…");
        Scanner sc = new Scanner(System.in);

        System.out.println("How many days is the journey planned for?");
        int     days = sc.nextInt();
        System.out.println("How many liters of water are needed per traveler per day?");
        float   water =  sc.nextFloat();
        System.out.println("How many kilograms of food are needed per traveler per day?");
        float   food = sc.nextFloat();
        System.out.println("How many oxygen tanks are needed per traveler per day?");
        int     tanks = sc.nextInt();
        System.out.println("How many people are going on the journey?");
        int     people = sc.nextInt();
        Resources resources = new Resources(days, water, food, tanks, people);

        ResourceCalculator calc = new ResourceCalculator(resources); //so weird that I never need to delete this
        System.out.println("Total resource requirements for the journey:");
        System.out.println(calc.getTotalWater() + " liters of water");
        System.out.println(calc.getTotalFood() + " kilograms of food");
        System.out.println(calc.getTotalOxygenTanks() + " oxygen tanks");
        return resources;
    }

    static Resources collectResources() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter available liters of water:");
        float   water =  sc.nextFloat();
        System.out.println("Enter available kilograms of food:");
        float   food = sc.nextFloat();
        System.out.println("Enter available oxygen tanks:");
        int     tanks = sc.nextInt();
        return new Resources(-1, water, food, tanks, -1);
    }

    static boolean checkResources(Resources needed, Resources available) {
        ResourceChecker checker = new ResourceChecker(available);
        ResourceCheckResult result = checker.checkResources(needed);
        if (!result.journeyPossible()) {
            System.out.print("No, the journey cannot be made for the planned number of days. ");
            System.out.println("The journey can only last " + result.getPossibleDays() + " days.");
            return false;
        }
        else if (result.hasSurplus()) {
            System.out.println("Yes, the journey can be made, and it can last " + result.getExtraDays() + " days longer.");
        }
        else {
            System.out.println("Yes, the journey can be made.");
        }
        return true;
    }

    static void countdown() {
        System.out.println("Countdown:\n3 ...");
        pause();
        System.out.println("2 ...");
        pause();
        System.out.println("1 ...");
        pause();
    }

    static void startSpaceJourney() {
        System.out.println("The space journey begins");
    }
}