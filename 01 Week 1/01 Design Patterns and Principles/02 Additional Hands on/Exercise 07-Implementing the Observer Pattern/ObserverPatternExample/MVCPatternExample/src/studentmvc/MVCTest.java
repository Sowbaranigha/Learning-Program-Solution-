package studentmvc;

public class MVCTest {
    public static void main(String[] args) {

    	//1.create model
        Student student = new Student("Alice", "S001", "A");

        //2. create view
        StudentView view = new StudentView();

        // 3.create controller linking model and view
        StudentController controller = new StudentController(student, view);

        //4.initial display
        controller.updateView();

        //5.modify data via controller
        controller.setStudentName("Alice Johnson");
        controller.setStudentGrade("A+");
        
        //6.display after update
        System.out.println("\nAfter update through controller:");
        controller.updateView();
    }
}
