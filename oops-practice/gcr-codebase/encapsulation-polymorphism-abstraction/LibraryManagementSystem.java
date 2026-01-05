interface Reservable {
    void reserveItem();

    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    LibraryItem(String id, String title, String author) {
        this.itemId = id;
        this.title = title;
        this.author = author;
    }

    abstract int getLoanDuration();

    void getItemDetails() {
        System.out.println(title + " by " + author);
    }
}

class Book extends LibraryItem implements Reservable {
    Book(String id, String title, String author) {
        super(id, title, author);
    }

    int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        System.out.println("Book Reserved");
    }

    public boolean checkAvailability() {
        return true;
    }
}
