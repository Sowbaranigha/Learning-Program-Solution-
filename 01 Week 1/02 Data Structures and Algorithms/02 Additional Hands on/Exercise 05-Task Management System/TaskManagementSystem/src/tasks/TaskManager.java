package tasks;

public class TaskManager {
    private Task head;
    

    // add new task at the end
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    // search task by Id
    public Task searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // traverse all tasks
    public void displayTasks() {
        Task temp = head;
        if (temp == null) {
            System.out.println("No tasks found.");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // delete all task by Id
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task prev = head;
        Task current = head.next;

        while (current != null && current.taskId != id) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}
