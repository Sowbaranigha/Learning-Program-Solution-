package library;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManager {
    Book[] books;

    public LibraryManager(Book[] books) {
        this.books = books;
    }

    //linear search by title
    public void linearSearch(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found (Linear): " + book);
                found = true;
            }
        }
        if (!found) System.out.println("Book not found (Linear)");
    }
    
    // binary search by title(array must be sorted)
    public void binarySearch(String title) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                System.out.println("Found (Binary): " + books[mid]);
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book not found (Binary)");
    }
}
