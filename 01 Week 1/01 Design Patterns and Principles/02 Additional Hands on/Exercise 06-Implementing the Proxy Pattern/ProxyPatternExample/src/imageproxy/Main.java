package imageproxy;

public class Main {
    public static void main(String[] args) {

        Image img1 = new ProxyImage("hero.png");
        Image img2 = new ProxyImage("logo.jpg");

        // first display - triggers download
        img1.display();
        System.out.println();

        // second display of same image - uses cache
        img1.display();          // just displays
        System.out.println();

        // another image
        img2.display();          //loads + displays
    }
}
