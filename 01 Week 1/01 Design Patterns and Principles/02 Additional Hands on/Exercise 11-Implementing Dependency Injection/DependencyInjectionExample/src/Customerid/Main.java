package Customerid;

public class Main {
    public static void main(String[] args) {
    	
    	// dependency injection - inject repository into service
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        // test
        service.printCustomer("101");// existing
        service.printCustomer("999");// non existing
    }
}
