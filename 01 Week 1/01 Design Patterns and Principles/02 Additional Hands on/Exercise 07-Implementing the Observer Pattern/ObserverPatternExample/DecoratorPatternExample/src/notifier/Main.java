package notifier;

public class Main {
    public static void main(String[] args) {

    	// Base notifier: email
        Notifier emailNotifier = new EmailNotifier();

        // add SMS on the top of email
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // add slack on top of the SMS + Email
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // final output: Email -> SMS -> Slack
        slackNotifier.send("Your order has been shipped!");
    }
}
