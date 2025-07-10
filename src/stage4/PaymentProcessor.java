package stage4;

public class PaymentProcessor {
    private final double costPerDay;

    public PaymentProcessor(double cost) {
        costPerDay = cost;
    }

    public PaymentCheckResult processPayment(PaymentMethod method, int days) {
        double amount = costPerDay * days;
        boolean possible = method.pay(amount);
        int days_possible = -1;
        if (!possible)
            days_possible = (int) (method.getRemainingFunds() / costPerDay);
        return new PaymentCheckResult(possible, days_possible, method.getRemainingFunds());
    }
}
