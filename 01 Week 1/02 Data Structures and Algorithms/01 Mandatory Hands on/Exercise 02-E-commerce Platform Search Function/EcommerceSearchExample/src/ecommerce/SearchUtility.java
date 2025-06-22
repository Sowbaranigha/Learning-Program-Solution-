package ecommerce;

import java.util.Arrays;
import java.util.Comparator;

public class SearchUtility {

    public static Product linearSearch(Product[] arr, int id) {
        for (Product p : arr) {
            if (p.getProductId() == id) return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] arr, int id) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = arr[mid].getProductId();
            if (midId == id) return arr[mid];
            else if (midId < id) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void sortProductsById(Product[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(Product::getProductId));
    }
}
