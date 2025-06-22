package Customerid;

public class CustomerService {
    private CustomerRepository repository;

    // constructor based dependency injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void printCustomer(String id) {
        Customer customer = repository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Found: " + customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}
