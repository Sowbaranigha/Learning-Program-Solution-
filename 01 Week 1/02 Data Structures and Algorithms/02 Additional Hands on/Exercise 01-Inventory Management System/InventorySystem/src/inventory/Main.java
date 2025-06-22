package inventory;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
          // add products
        manager.addProduct(new Product(101, "Mouse", 50, 399.00));
        manager.addProduct(new Product(102, "Keyboard", 40, 799.00));
        manager.addProduct(new Product(103, "Monitor", 10, 8999.00));
          
        System.out.println("Initial Inventory:");
        manager.displayAll();

         //update product
        manager.updateProduct(102, 35, 749.00);
         // delete product
        manager.deleteProduct(103);

        System.out.println("\nAfter Update & Delete:");
        manager.displayAll();
    }
}
