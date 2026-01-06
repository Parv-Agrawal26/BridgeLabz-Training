import java.util.*;

class BookNotAvailableException extends Exception {
    BookNotAvailableException(String message) {
        super(message);
    }
}

class Book {
    String title;
    String author;
    boolean available;

    Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }
}

public class LibraryManagementSystem {

    static List<Book> bookList = new ArrayList<>();

    static void displayBooks() {
        for (Book book : bookList) {
            System.out
                    .println(book.title + " | " + book.author + " | " + (book.available ? "Available" : "Checked Out"));
        }
    }

    static void searchBook(String keyword) {
        for (Book book : bookList) {
            if (book.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book.title + " by " + book.author);
            }
        }
    }

    static void checkoutBook(String title) throws BookNotAvailableException {
        for (Book book : bookList) {
            if (book.title.equalsIgnoreCase(title)) {
                if (!book.available) {
                    throw new BookNotAvailableException("Book already checked out");
                }
                book.available = false;
                System.out.println("Book checked out successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        bookList.add(new Book("Java Basics", "James", true));
        bookList.add(new Book("Python Guide", "Rossum", false));

        displayBooks();
        searchBook("java");

        try {
            checkoutBook("Python Guide");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
