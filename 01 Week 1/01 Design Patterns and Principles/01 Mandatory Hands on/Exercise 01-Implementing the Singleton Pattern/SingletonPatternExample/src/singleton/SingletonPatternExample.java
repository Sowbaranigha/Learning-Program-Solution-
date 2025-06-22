package singleton;

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger firstRef = Logger.getInstance();
        Logger secondRef = Logger.getInstance();

        firstRef.log("First reference is logging.");
        secondRef.log("Second reference is logging.");

        System.out.println("firstRef  hashCode: " + firstRef.hashCode());
        System.out.println("secondRef hashCode: " + secondRef.hashCode());

        if (firstRef == secondRef) {
            System.out.println("Success: Only one Logger instance exists.");
        } else {
            System.out.println("Error: Different Logger instances detected!");
        }
    }
}
