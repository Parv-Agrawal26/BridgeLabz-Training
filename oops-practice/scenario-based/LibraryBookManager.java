import java.util.*;

class Book {
    private String title;
    private String author;
    private String genre;
    private int yearPublished;

    Book(String title, String author, String genre, int yearPublished) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getAuthor() {
        return author;
    }
}

public class LibraryBookManager {

    static List<Book> getBooksAfter2000(List<Book> bookList) {
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getYearPublished() > 2000) {
                filteredBooks.add(book);
            }
        }

        filteredBooks.sort(new Comparator<Book>() {
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });

        return filteredBooks;
    }

    static Map<String, Integer> groupBooksByGenre(List<Book> bookList) {
        Map<String, Integer> genreMap = new HashMap<>();

        for (Book book : bookList) {
            String genre = book.getGenre();
            if (genreMap.containsKey(genre)) {
                genreMap.put(genre, genreMap.get(genre) + 1);
            } else {
                genreMap.put(genre, 1);
            }
        }
        return genreMap;
    }

    public static void main(String[] args) {

        List<Book> library = new ArrayList<>();

        library.add(new Book("Clean Code", "Robert Martin", "Programming", 2008));
        library.add(new Book("Effective Java", "Joshua Bloch", "Programming", 2018));
        library.add(new Book("Harry Potter", "J K Rowling", "Fantasy", 1999));
        library.add(new Book("The Hobbit", "J R R Tolkien", "Fantasy", 2001));
        library.add(new Book("World History", "Norman Lowe", "History", 2005));

        System.out.println("Books published after 2000:");
        List<Book> recentBooks = getBooksAfter2000(library);
        for (Book book : recentBooks) {
            System.out.println("- " + book.getTitle());
        }

        System.out.println("\nBooks grouped by genre:");
        Map<String, Integer> groupedBooks = groupBooksByGenre(library);
        for (String genre : groupedBooks.keySet()) {
            System.out.println(genre + ": " + groupedBooks.get(genre));
        }
    }
}
