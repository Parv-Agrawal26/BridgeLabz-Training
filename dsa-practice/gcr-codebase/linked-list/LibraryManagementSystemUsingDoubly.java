public class LibraryManagementSystemUsingDoubly {
    public static void main(String[] args) {
        LibraryList library = new LibraryList();

        library.addFirst(new Book("Clean Code", "Robert C. Martin", "Programming", 201, true));
        library.addLast(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 202, true));
        library.addAtPosition(new Book("Dune", "Frank Herbert", "Sci-Fi", 203, false), 1);

        System.out.println("Books forward:");
        library.displayForward();

        System.out.println("\nBooks reverse:");
        library.displayReverse();

        System.out.println("\nSearch by title 'Dune':");
        library.searchByTitle("Dune");

        System.out.println("\nSearch by author 'Robert C. Martin':");
        library.searchByAuthor("Robert C. Martin");

        System.out.println("\nUpdate availability (Book ID 203 -> true):");
        library.updateAvailability(203, true);

        System.out.println("\nRemove Book ID 202:");
        library.removeById(202);

        System.out.println("\nBooks forward (final):");
        library.displayForward();

        System.out.println("\nTotal books: " + library.count());
    }

    static final class Book {
        final String title;
        final String author;
        final String genre;
        final int id;
        boolean available;

        Book(String title, String author, String genre, int id, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.id = id;
            this.available = available;
        }
    }

    static final class LibraryList {
        private static final class Node {
            Book data;
            Node next;
            Node prev;

            Node(Book data) {
                this.data = data;
            }
        }

        private Node head;
        private Node tail;

        void addFirst(Book book) {
            Node newNode = new Node(book);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            System.out.println("Book added at beginning");
        }

        void addLast(Book book) {
            Node newNode = new Node(book);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            System.out.println("Book added at end");
        }

        void addAtPosition(Book book, int position) {
            if (position <= 0 || head == null) {
                addFirst(book);
                return;
            }

            Node current = head;
            int index = 0;
            while (current.next != null && index < position - 1) {
                current = current.next;
                index++;
            }

            Node newNode = new Node(book);
            Node next = current.next;

            current.next = newNode;
            newNode.prev = current;
            newNode.next = next;

            if (next != null) {
                next.prev = newNode;
            } else {
                tail = newNode;
            }

            System.out.println("Book added at position " + position);
        }

        boolean removeById(int bookId) {
            Node current = head;
            while (current != null) {
                if (current.data.id == bookId) {
                    Node prev = current.prev;
                    Node next = current.next;

                    if (prev != null) {
                        prev.next = next;
                    } else {
                        head = next;
                    }

                    if (next != null) {
                        next.prev = prev;
                    } else {
                        tail = prev;
                    }

                    System.out.println("Book with ID " + bookId + " removed");
                    return true;
                }
                current = current.next;
            }
            System.out.println("Book with ID " + bookId + " not found");
            return false;
        }

        void searchByTitle(String title) {
            Node current = head;
            while (current != null) {
                if (current.data.title.equalsIgnoreCase(title)) {
                    printBook(current.data);
                    return;
                }
                current = current.next;
            }
            System.out.println("No book found with title '" + title + "'");
        }

        void searchByAuthor(String author) {
            Node current = head;
            while (current != null) {
                if (current.data.author.equalsIgnoreCase(author)) {
                    printBook(current.data);
                    return;
                }
                current = current.next;
            }
            System.out.println("No book found with author '" + author + "'");
        }

        boolean updateAvailability(int bookId, boolean available) {
            Node current = head;
            while (current != null) {
                if (current.data.id == bookId) {
                    current.data.available = available;
                    System.out.println("Availability updated for Book ID " + bookId);
                    return true;
                }
                current = current.next;
            }
            System.out.println("Book with ID " + bookId + " not found");
            return false;
        }

        void displayForward() {
            if (head == null) {
                System.out.println("Library is empty");
                return;
            }
            Node current = head;
            while (current != null) {
                printBook(current.data);
                current = current.next;
            }
        }

        void displayReverse() {
            if (tail == null) {
                System.out.println("Library is empty");
                return;
            }
            Node current = tail;
            while (current != null) {
                printBook(current.data);
                current = current.prev;
            }
        }

        int count() {
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        private static void printBook(Book book) {
            System.out.println(
                    "Title: " + book.title + ", Author: " + book.author + ", Genre: " + book.genre + ", ID: "
                            + book.id + ", Available: " + book.available);
        }
    }
}
