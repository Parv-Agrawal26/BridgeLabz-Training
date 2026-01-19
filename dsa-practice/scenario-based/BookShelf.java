
import java.util.*;

class BookShelf {

    private HashMap<String, LinkedList<String>> catalog = new HashMap<>();
    private HashSet<String> uniqueBooks = new HashSet<>();

    void addBook(String genre, String bookName) {

        if (uniqueBooks.contains(bookName)) {
            System.out.println("Duplicate book ignored");
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(bookName);
        uniqueBooks.add(bookName);
    }

    void removeBook(String genre, String bookName) {

        if (catalog.containsKey(genre)) {
            catalog.get(genre).remove(bookName);
            uniqueBooks.remove(bookName);
        }
    }

    void displayCatalog() {

        for (String genre : catalog.keySet()) {
            System.out.println(genre + " : " + catalog.get(genre));
        }
    }

    public static void main(String[] args) {

        BookShelf shelf = new BookShelf();
        shelf.addBook("Fiction", "1984");
        shelf.addBook("Fiction", "Animal Farm");
        shelf.addBook("Science", "Cosmos");
        shelf.displayCatalog();
    }
}
