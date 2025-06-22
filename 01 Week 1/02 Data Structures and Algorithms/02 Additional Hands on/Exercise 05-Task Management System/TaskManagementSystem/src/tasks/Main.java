package tasks;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // add tasks
        manager.addTask(1, "Design UI", "Pending");
        manager.addTask(2, "Implement Backend", "In Progress");
        manager.addTask(3, "Testing", "Pending");

        System.out.println("All Tasks:");
        manager.displayTasks();

        //search task
        System.out.println("\nSearching for task ID 2:");
        Task result = manager.searchTask(2);
        System.out.println(result != null ? result : "Not Found");

        // delete task
        System.out.println("\nDeleting task ID 1:");
        manager.deleteTask(1);

        // display again
        System.out.println("\nAfter Deletion:");
        manager.displayTasks();
    }
}
