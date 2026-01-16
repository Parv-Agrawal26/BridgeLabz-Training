public class SortStudentAges {
    public static void main(String[] args) {
        int[] studentAges = { 18, 22, 20, 19, 21, 23, 20, 22, 19, 18 };
        countingSort(studentAges);
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }

    public static void countingSort(int[] ages) {
        int maxAge = 0;
        for (int age : ages) {
            if (age > maxAge) {
                maxAge = age;
            }
        }
        int[] count = new int[maxAge + 1];
        for (int age : ages) {
            count[age]++;
        }
        int index = 0;
        for (int i = 0; i <= maxAge; i++) {
            while (count[i] > 0) {
                ages[index++] = i;
                count[i]--;
            }
        }
    }
}
