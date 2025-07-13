package stage5;

import stage3.ResourceCheckResult;
import stage3.Resources;

import java.util.Scanner;

public class View {

    public static void checkHealthAndApproveTravelers() {
        System.out.println("Health checking of the travelers and approval for the journey...");
        pause();
        OK();
    }

    public static Resources askforRequiredResources() {
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
        return new Resources(days, water, food, tanks, people);
    }

    public static void displayRequiredResources(Resources resources) {
        System.out.println("Total resource requirements for the journey:");
        System.out.println(resources.getWater() + " liters of water");
        System.out.println(resources.getFood() + " kilograms of food");
        System.out.println(resources.getTanks() + " oxygen tanks");
    }

    static Resources collectAvailableResources() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter available liters of water:");
        float   water =  sc.nextFloat();
        System.out.println("Enter available kilograms of food:");
        float   food = sc.nextFloat();
        System.out.println("Enter available oxygen tanks:");
        int     tanks = sc.nextInt();
        return new Resources(-1, water, food, tanks, -1);
    }

    public static void displayPossibilityOfJourney(ResourceCheckResult result) {
        if (!result.journeyPossible()) {
            System.out.print("No, the journey cannot be made for the planned number of days. ");
            System.out.println("The journey can only last " + result.getPossibleDays() + " days.");
        }
        else if (result.hasSurplus()) {
            System.out.println("Yes, the journey can be made, and it can last " + result.getExtraDays() + " days longer.");
        }
        else {
            System.out.println("Yes, the journey can be made.");
        }
    }

    private static void pause() {
        try {
            Thread.sleep(2000); }
        catch (InterruptedException e) {
            System.err.println("This is weird how did this happen");
        }
    }

    private static void OK() {
        System.out.println("OK");
    }

    private static void countdown() {
        System.out.println("Countdown:\n3 ...");
        pause();
        System.out.println("2 ...");
        pause();
        System.out.println("1 ...");
        pause();
    }

    private static void startSpaceJourney() {
        System.out.println("The space journey begins");
    }


}
