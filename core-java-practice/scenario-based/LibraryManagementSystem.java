import java.util.Scanner;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String title = scn.nextLine();
        String author = scn.nextLine();
        String status = scn.nextLine();
        String[] bookDetails = new String[3];
        bookDetails[0] = title;
        bookDetails[1] = author;
        bookDetails[2] = status;
        displayBookDetails(bookDetails);
        issueBook(bookDetails);
        displayBookDetails(bookDetails);
        returnBook(bookDetails);
        displayBookDetails(bookDetails);
        searchBook(bookDetails, scn.nextLine());

    }
    public static void displayBookDetails(String[] bookDetails) {
        System.out.println("Title: " + bookDetails[0]);
        System.out.println("Author: " + bookDetails[1]);
        System.out.println("Status: " + bookDetails[2]);
    }
    public static void issueBook(String[] bookDetails) {
        if (bookDetails[2].equals("Available")) {
            bookDetails[2] = "Issued";
            System.out.println("The book has been issued.");
        } else {
            System.out.println("The book is currently not available.");
        }
    }
    public static void returnBook(String[] bookDetails) {
        if (bookDetails[2].equals("Issued")) {
            bookDetails[2] = "Available";
            System.out.println("The book has been returned.");
        } else {
            System.out.println("The book was not issued.");
        }
    }
    public static void searchBook(String[] bookDetails, String searchTitle) {
        if (bookDetails[0].contains(searchTitle)) {
            System.out.println("Book found by title: " + bookDetails[0]);
            displayBookDetails(bookDetails);
        } else {
            System.out.println("Book not found.");
        }
    }
}
