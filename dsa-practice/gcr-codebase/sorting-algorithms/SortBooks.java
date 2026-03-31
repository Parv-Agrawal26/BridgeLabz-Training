public class SortBooks {
    public static void main(String[] args) {
        int[] books = {5, 2, 9, 1, 5, 6};
        mergeSort(books, 0, books.length - 1);
        for (int book : books) {
            System.out.print(book + " ");
        }
    }
    public static void mergeSort(int[] books, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(books, left, mid);
            mergeSort(books, mid + 1, right);
            merge(books, left, mid, right);
        }
    }
    public static void merge(int[] books, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = books[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = books[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                books[k] = L[i];
                i++;
            } else {
                books[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            books[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            books[k] = R[j];
            j++;
            k++;
        }
    }
}
