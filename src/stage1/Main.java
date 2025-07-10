package stage1;
import stage2.ResourceCalculator;
import stage3.Resources;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting preparation for the space journey");
        checkHealthAndApproveTravelers();
        calculateRequiredResources();
        checkResources();
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

    static void calculateRequiredResources() {
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
    }

    static void checkResources() {
        System.out.println("Checking available resources…");
        pause();
        OK();
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