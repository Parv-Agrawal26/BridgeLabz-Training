public class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void printDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
    public static void main(String[] args) {
        Book book1 = new Book("Book1", "Parv", 100);
        Book book2 = new Book("Book2", "Raj", 500);
        book1.printDetails();
        System.out.println();
        book2.printDetails();
    }
}
