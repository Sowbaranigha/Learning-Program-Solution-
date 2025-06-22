package forecasting;

public class forecast {
         
	  // recursive method to calculate future value 
    public static double futureValue(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;
        return futureValue(presentValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double present = 10000;      // initial amount
        double rate = 0.05;          // 5% annual growth
        int years = 5;               // time period

        double result = futureValue(present, rate, years);

        System.out.printf("Future Value after %d years: ₹%.2f\n", years, result);
    }
}
