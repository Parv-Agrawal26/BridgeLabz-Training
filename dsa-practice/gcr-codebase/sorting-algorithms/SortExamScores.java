public class SortExamScores {
    public static void main(String[] args) {
        int[] examScores = { 88, 56, 100, 2, 25, 78, 45, 89, 90, 67 };
        selectionSort(examScores);
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }

    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }
}