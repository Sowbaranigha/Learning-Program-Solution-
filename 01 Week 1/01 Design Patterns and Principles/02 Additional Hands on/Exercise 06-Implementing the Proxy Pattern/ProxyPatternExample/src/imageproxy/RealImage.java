package imageproxy;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + fileName + " from remote server...");
        // simulate network delay
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
