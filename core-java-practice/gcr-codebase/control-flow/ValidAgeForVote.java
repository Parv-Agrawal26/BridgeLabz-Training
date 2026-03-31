import java.util.Scanner;
public class ValidAgeForVote {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int age = scn.nextInt();
        if (age >= 18) {
            System.out.println("The person's age is "+ age +" and is eligible to vote.");
        } else {
            System.out.println("The person's age is "+ age +" and is not eligible to vote.");
        }
    }
}
