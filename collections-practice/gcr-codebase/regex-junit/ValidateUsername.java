import java.util.Scanner;
import java.util.regex.*;

class ValidateUsername {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scn.nextLine();

        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        boolean valid = username.matches(regex);

        if (valid)
            System.out.println("Valid Username");
        else
            System.out.println("Invalid Username");
    }
}
