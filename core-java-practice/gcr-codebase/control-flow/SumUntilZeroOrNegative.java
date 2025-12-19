import java.util.Scanner;
class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            double value = scn.nextDouble();
            if (value <= 0) {
                break;
            }
            total = total + value;
        }
        System.out.println("The total value is " + total);
    }
}
