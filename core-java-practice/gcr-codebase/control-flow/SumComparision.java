import java.util.Scanner;

class SumComparison {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sumUsingFormula = n * (n + 1) / 2;
        int sumUsingLoop = 0;
        while (n >= 1) {
            sumUsingLoop += n;
            n--;
        }
        if (sumUsingFormula == sumUsingLoop) {
            System.out.println("Both methods give the same sum");
        } else {
            System.out.println("Both sums are different.");
        }
    }
}
