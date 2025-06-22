package payment;

public class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Paid ₹" + amount + " using Stripe.");
    }
}
