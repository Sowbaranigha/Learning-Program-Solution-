package payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        System.out.println("Choose payment method (1=Credit Card, 2=PayPal): ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter card number: ");
                String card = sc.nextLine();
                context.setStrategy(new CreditCardPayment(card));
            }
            case 2 -> {
                System.out.print("Enter PayPal email: ");
                String mail = sc.nextLine();
                context.setStrategy(new PayPalPayment(mail));
            }
            default -> System.out.println("Invalid choice");
        }

        context.pay(amt);
        sc.close();
    }
}
