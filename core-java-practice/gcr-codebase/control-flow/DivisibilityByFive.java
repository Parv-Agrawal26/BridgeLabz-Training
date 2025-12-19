import java.util.Scanner;
public class DivisibilityByFive {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        if (number % 5 == 0) {
            System.out.println(number + " is divisible by 5.");
        } else {
            System.out.println(number + " is not divisible by 5.");
        }
    }
}