package stockapp;

public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println(appName + " MobileApp received update: " + stockName + " = ₹" + stockPrice);
    }
}