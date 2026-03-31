public class SortEmployeeId {
    public static void main(String[] args) {
        int[] employeeIds = {1,5,8,4,2,5,7,9,89,5,44,98};
        insertionSort(employeeIds);
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
    public static void insertionSort(int[] empIds) {
        int n = empIds.length;
        for (int i = 1; i < n; i++) {
            int key = empIds[i];
            int j = i - 1;
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j = j - 1;
            }
            empIds[j + 1] = key;
        }
    }
}
