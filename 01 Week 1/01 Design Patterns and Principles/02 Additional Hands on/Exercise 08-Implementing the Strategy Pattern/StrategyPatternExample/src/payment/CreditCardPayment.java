package payment;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " with Credit Card (" + mask(cardNumber) + ")");
    }

    private String mask(String card) {
        return "XXXX-XXXX-XXXX-" + card.substring(card.length() - 4);
    }
}
