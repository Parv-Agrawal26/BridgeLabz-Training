import java.util.Scanner;
public class CheckNaturalAndSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        if (number > 0) {
            System.out.println(number + " is natural number");
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            System.out.println("Sum of natural numbers is: " + sum);
        } else {
            System.out.println(number + " is not natural number.");
        }
    }
}
