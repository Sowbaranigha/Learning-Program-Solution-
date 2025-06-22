package orders;

public class Main {
    public static void main(String[] args) {
        Order[] orderList = {
            new Order(1, "Ajay", 1200.00),
            new Order(2, "Bency", 950.00),
            new Order(3, "Charlie", 1500.00),
            new Order(4, "Diana", 300.00)
        };

        System.out.println("Before Sorting:");
        for (Order o : orderList) System.out.println(o);

        // sort using bubble sort
        SortOrders.bubbleSort(orderList);
        System.out.println("\nAfter Bubble Sort:");
        for (Order o : orderList) System.out.println(o);

         // shuffle the array again for quick sort 
        orderList = new Order[] {
            new Order(1, "Ajay", 1200.00),
            new Order(2, "Bency", 950.00),
            new Order(3, "Charlie", 1500.00),
            new Order(4, "Diana", 300.00)
        };

        // sort using quick sort
        SortOrders.quickSort(orderList, 0, orderList.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order o : orderList) System.out.println(o);
    }
}
