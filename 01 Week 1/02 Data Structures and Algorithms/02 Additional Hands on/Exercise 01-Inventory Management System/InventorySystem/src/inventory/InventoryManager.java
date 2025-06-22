package inventory;

import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();
         // add product
    public void addProduct(Product p) {
        inventory.put(p.getProductId(), p);
    }
          // update product
    public void updateProduct(int id, int newQty, double newPrice) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.setQuantity(newQty);
            p.setPrice(newPrice);
        } else {
            System.out.println("Product not found.");
        }
    }
       // delete product
    public void deleteProduct(int id) {
        inventory.remove(id);
    }
       //display all products
    public void displayAll() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
