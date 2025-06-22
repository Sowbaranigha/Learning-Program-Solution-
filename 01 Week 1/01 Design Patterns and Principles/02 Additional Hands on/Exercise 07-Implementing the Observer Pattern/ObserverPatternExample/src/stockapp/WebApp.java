package stockapp;

public class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println(appName + " WebApp received update: " + stockName + " = ₹" + stockPrice);
    }
}
