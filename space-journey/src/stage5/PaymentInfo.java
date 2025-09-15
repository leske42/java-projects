package stage5;

public class PaymentInfo {
    private final double cost;
    private final int    method;
    private final double money;

    public PaymentInfo(double cost, int method, double money) {
        this.cost = cost;
        this.method = method;
        this.money = money;
    }
    public double getCost() {
        return cost;
    }
    public int getMethod() {
        return method;
    }

    public String getMethodName() {
        if (method == 1)
            return "Card";
        else
            return "Cash";
    }

    public double getMoney() {
        return money;
    }
}