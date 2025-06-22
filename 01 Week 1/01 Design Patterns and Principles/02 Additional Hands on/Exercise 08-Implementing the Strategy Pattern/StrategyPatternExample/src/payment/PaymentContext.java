package payment;

public class PaymentContext {
    private PaymentStrategy strategy;

    // choose strategy at runtime
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // delegates payment to the chosen strategy
    public void pay(double amount) {
        if (strategy == null) {
            System.out.println("Payment strategy not set!");
            return;
        }
        strategy.pay(amount);
    }
}
