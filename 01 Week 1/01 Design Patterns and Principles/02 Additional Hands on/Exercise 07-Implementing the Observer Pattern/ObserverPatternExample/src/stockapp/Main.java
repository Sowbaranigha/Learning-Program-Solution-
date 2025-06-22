package stockapp;

public class Main {
    public static void main(String[] args) {
    	
    	// create stock market subject
        StockMarket tcsStock = new StockMarket("TCS", 3500.0);

        // create observers
        Observer mobile = new MobileApp("NSE Tracker");
        Observer web = new WebApp("InvestPro");

        // register observers
        tcsStock.registerObserver(mobile);
        tcsStock.registerObserver(web);

        // update stock prices
        tcsStock.setStockPrice(3600.5);
        tcsStock.setStockPrice(3700.75);

        // remove one observer
        tcsStock.removeObserver(mobile);

        // update again
        tcsStock.setStockPrice(3800.25);
    }
}
