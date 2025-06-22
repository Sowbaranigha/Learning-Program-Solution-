package stockapp;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.stockPrice = initialPrice;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double newPrice) {
        System.out.println("\nStock price updated: " + stockName + " = ₹" + newPrice);
        this.stockPrice = newPrice;
        notifyObservers();
    }
}
