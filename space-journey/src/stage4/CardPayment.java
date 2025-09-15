package stage4;

public class CardPayment implements PaymentMethod {
    private double balance;
    private static final double FEE_RATE = 0.02;

    public CardPayment(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        amount += amount * FEE_RATE;
        if (amount > balance)
            return false;
        balance -= amount;
        return true;
    }

    @Override
    public double getRemainingFunds() {
        return balance;
    }

    @Override
    public String getMethodName() {
        return "Card";
    }
}
