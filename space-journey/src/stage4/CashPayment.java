package stage4;

public class CashPayment implements PaymentMethod {
    private double cashAvailable;

    public CashPayment(double cash) {
        this.cashAvailable = cash;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > cashAvailable)
            return false;
        cashAvailable -= amount;
        return true;
    }

    @Override
    public double getRemainingFunds() {
        return cashAvailable;
    }

    @Override
    public String getMethodName() {
        return "Cash";
    }
}
