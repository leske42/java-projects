package stage4;

public class PaymentProcessor {
    private final double costPerDay;

    public PaymentProcessor(double cost) {
        costPerDay = cost;
    }

    public PaymentCheckResult processPayment(PaymentMethod method, int amount) {
        int days = (int) (amount / costPerDay);
        boolean possible = method.pay(amount);
        return new PaymentCheckResult(possible, days, method.getRemainingFunds());
    }
}
