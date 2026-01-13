public class SmartShelf {

    static void insertionSort(String[] books) {
        for (int i = 1; i < books.length; i++) {
            String key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].compareToIgnoreCase(key) > 0) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        String[] books = { "Java", "Algorithms", "Data", "Python", "C" };

        insertionSort(books);

        for (String b : books) {
            System.out.println(b);
        }
    }
}
