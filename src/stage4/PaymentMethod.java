package stage4;

public interface PaymentMethod {
    boolean pay(double amount);
    String getMethodName();
    double getRemainingFunds();
}
