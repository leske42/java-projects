package stage1;
import stage2.ResourceCalculator;
import stage3.*;
import stage4.*;
import stage5.Controller;
import stage5.Model;
import stage5.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting preparation for the space journey");
        Controller.run();
//        checkHealthAndApproveTravelers();
//        Resources needed = calculateRequiredResources();
//        Resources available = collectResources();
//        if (!checkResources(needed, available) || !processPaymentForJourney(needed)) {
//            return ;
//        }
        countdown();
        startSpaceJourney();
    }

    static boolean processPaymentForJourney(Resources needed) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Payment for the space journey");
        System.out.println("Enter the cost per day of the journey:");
        double cost = sc.nextDouble();
        int method = -1;
        while (!(method == 1 || method == 2)) {
            System.out.println("Choose payment method:\n1 – Card (2% fee)\n2 – Cash");
            method = sc.nextInt();
        }
        System.out.println("Enter available amount of money:");
        double money = sc.nextDouble();
        PaymentMethod payment;
        if (method == 1)
            payment = new CardPayment(money);
        else
            payment = new CashPayment(money);
        PaymentProcessor proc = new PaymentProcessor(cost);
        PaymentCheckResult result = proc.processPayment(payment, needed.getDays());
        if (result.isFullJourneyAffordable()) {
            System.out.println("Payment successful. Full journey can be afforded.");
            System.out.println("They payment was made by " + payment.getMethodName());
            System.out.println("Remaining funds: " + result.getRemainingFunds());
            return true;
        }
        else if (result.getAffordableDays() > 0)
            System.out.println("Not enough money for full journey. You can travel for " + result.getAffordableDays() + " days.");
        else
            System.out.println("Insufficient funds. The journey cannot be paid for.");
        return false;
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