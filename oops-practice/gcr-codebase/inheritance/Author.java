class Book {
    String title;
    int publicationYear;

    Book(String title, int year) {
        this.title = title;
        this.publicationYear = year;
    }

    void displayInfo() {
        System.out.println(title + " " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int year, String name, String bio) {
        super(title, year);
        this.name = name;
        this.bio = bio;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println(name + " " + bio);
    }

    public static void main(String[] args) {
        Author a = new Author("Java", 2023, "James", "Java Creator");
        a.displayInfo();
    }
}
