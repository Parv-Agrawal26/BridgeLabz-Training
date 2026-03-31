public class SortStudentMarks {
    public static void main(String[] args) {
        int[] studentMarks = {3,7,21,1,4,9,4,2,8,96,23};
        bubbleSort(studentMarks);
        for (int mark : studentMarks) {
            System.out.print(mark + " ");
        }
    }
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }
}
