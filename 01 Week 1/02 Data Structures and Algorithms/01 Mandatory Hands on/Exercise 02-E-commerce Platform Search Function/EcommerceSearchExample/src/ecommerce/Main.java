package ecommerce;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(103, "Mouse", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(105, "Desk", "Furniture"),
            new Product(104, "Chair", "Furniture"),
            new Product(102, "Keyboard", "Electronics")
        };
            // linear search
        System.out.println("Linear Search:");
        Product result1 = SearchUtility.linearSearch(products, 105);
        System.out.println(result1 != null ? "Found: " + result1 : "Not Found");
           // sort before binary search
        SearchUtility.sortProductsById(products);
           // binary search
        System.out.println("\nBinary Search:");
        Product result2 = SearchUtility.binarySearch(products, 105);
        System.out.println(result2 != null ? "Found: " + result2 : "Not Found");
    }
}
