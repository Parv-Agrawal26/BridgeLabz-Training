import java.util.Scanner;

class ValidateSSN {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter SSN:");
        String ssn = scn.nextLine();

        if (ssn.matches("\\d{3}-\\d{2}-\\d{4}"))
            System.out.println("Valid SSN");
        else
            System.out.println("Invalid SSN");
    }
}
