package payment;

public class Main {
    public static void main(String[] args) {
    	
    	// PayPal adapter
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(500);

        // Stripe adapter
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(750);
    }
}
