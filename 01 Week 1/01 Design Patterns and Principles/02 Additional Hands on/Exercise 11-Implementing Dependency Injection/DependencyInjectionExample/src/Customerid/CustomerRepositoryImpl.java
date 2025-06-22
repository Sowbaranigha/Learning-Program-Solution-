package Customerid;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database = new HashMap<>();

    // simulated data
    public CustomerRepositoryImpl() {
        database.put("101", new Customer("101", "Alice"));
        database.put("102", new Customer("102", "Bob"));
    }

    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}
