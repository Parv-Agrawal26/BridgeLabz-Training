import java.util.Scanner;

class SumNaturalRecursive {
    static int sumRec(int number) {
        if (number == 0)
            return 0;
        return number + sumRec(number - 1);
    }

    static int sumFormula(int number) {
        return number * (number + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        if (number <= 0) {
            System.out.println("Not natural number");
            return;
        }
        int rec = sumRec(number);
        int formula = sumFormula(number);
        System.out.println("Recursive sum " + rec);
        System.out.println("Formula sum " + formula);
        System.out.println("Result same " + (rec == formula));
    }
}
