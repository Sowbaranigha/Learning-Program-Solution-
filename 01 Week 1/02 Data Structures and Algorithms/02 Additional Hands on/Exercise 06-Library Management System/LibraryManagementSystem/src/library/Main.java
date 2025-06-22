package library;

public class Main {
    public static void main(String[] args) {
        Book[] bookList = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "Wings of Fire", "A.P.J Abdul Kalam"),
            new Book(3, "Zero to One", "Peter Thiel"),
            new Book(4, "The Power of Habit", "Charles Duhigg")
        };

        LibraryManager manager = new LibraryManager(bookList);

        // search with linear
        manager.linearSearch("Wings of Fire");

        // search with binary
        manager.binarySearch("Wings of Fire");

        //try a missing book
        manager.linearSearch("Rich Dad Poor Dad");
        manager.binarySearch("Rich Dad Poor Dad");
    }
}
