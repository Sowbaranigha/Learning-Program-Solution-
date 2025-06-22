package employee;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        // add employees
        manager.addEmployee(new Employee(101, "Alice", "Manager", 60000));
        manager.addEmployee(new Employee(102, "Bob", "Developer", 50000));
        manager.addEmployee(new Employee(103, "Charlie", "Tester", 40000));

        System.out.println("All Employees:");
        manager.displayEmployees();

        // search employees
        System.out.println("\nSearching for employee ID 102:");
        Employee e = manager.searchEmployee(102);
        System.out.println(e != null ? e : "Not Found");

        // delete employees
        System.out.println("\nDeleting employee ID 101:");
        manager.deleteEmployee(101);

        // display again
        System.out.println("\nAfter Deletion:");
        manager.displayEmployees();
    }
}
