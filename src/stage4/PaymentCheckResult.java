package stage4;

public class PaymentCheckResult {
    private boolean fullJourneyAffordable;
    private int     affordableDays;
    private double  remainingFunds;

    public PaymentCheckResult(boolean possible, int days, double funds) {
        fullJourneyAffordable = possible;
        affordableDays = days;
        remainingFunds = funds;
    }

    public boolean isFullJourneyAffordable() {
        return fullJourneyAffordable;
    }
    public int getAffordableDays() {
        return affordableDays;
    }

    public double getRemainingFunds() {
        return remainingFunds;
    }
}
