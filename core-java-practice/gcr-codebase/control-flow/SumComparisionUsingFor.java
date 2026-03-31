import java.util.Scanner;

class SumComparisonUsingFor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sumUsingFormula = n * (n + 1) / 2;
        int sumUsingLoop = 0;
        for (int i = n; i >= 1; i--) {
            sumUsingLoop += i;
        }
        if (sumUsingFormula == sumUsingLoop) {
            System.out.println("Both methods give the same sum");
        } else {
            System.out.println("Both sums are different.");
        }
    }
}
