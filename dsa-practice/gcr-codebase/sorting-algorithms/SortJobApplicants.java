public class SortJobApplicants {
    public static void main(String[] args) {
        int[] jobApplicants = { 45000, 32000, 78000, 56000, 91000, 12000, 67000 };
        heapSort(jobApplicants);
        for (int salary : jobApplicants) {
            System.out.print(salary + " ");
        }
    }

    public static void heapSort(int[] applicants) {
        int n = applicants.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(applicants, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = applicants[0];
            applicants[0] = applicants[i];
            applicants[i] = temp;
            heapify(applicants, i, 0);
        }
    }

    public static void heapify(int[] applicants, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && applicants[left] > applicants[largest]) {
            largest = left;
        }
        if (right < n && applicants[right] > applicants[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = applicants[i];
            applicants[i] = applicants[largest];
            applicants[largest] = swap;
            heapify(applicants, n, largest);
        }
    }
}
