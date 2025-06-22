package imageproxy;

public class ProxyImage implements Image {
    private RealImage realImage;  // may stay null
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
    	// lazy initialization + caching
        if (realImage == null) {
            realImage = new RealImage(fileName);     // load only once
        }
        realImage.display();               // reuse thereafter
    }
}
