package stage1;

public class Main {
    public static void main(String[] args) {
        checkHealthAndApproveTravelers();
        processPaymentForJourney();
        calculateRequiredResources();
        checkResources();
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
        pause();
        OK();
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