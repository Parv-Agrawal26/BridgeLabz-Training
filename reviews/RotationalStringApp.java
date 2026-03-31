import java.util.Scanner;

public class RotationalStringApp {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String string1 = scn.nextLine();
        String string2 = scn.nextLine();

        // Use Case 1
        int length1 = string1.length();
        int length2 = string2.length();
        if (length1 != length2) {
            System.out.println("Rotation is not possible");
        }

        // Use Case 2
        string1 = string1 + string1;
        System.out.println("Concatenated string: " + string1);

        // Use Case 3
        boolean doesContain = false;
        if (string1.contains(string2)) {
            doesContain = true;
        }

        // Use Case 4
        if (doesContain) {
            System.out.println("Strings are rotational");
        } else {
            System.out.println("Strings are not rotational");
        }
    }

    // Use Case 5
    public static void checkRotational(String string1, String string2) {
        int length1 = string1.length();
        int length2 = string2.length();
        if (length1 != length2) {
            System.out.println("Rotation is not possible");
        }
        string1 = string1 + string1;
        System.out.println("Concatenated string: " + string1);
        boolean doesContain = false;
        if (string1.contains(string2)) {
            doesContain = true;
        }
        if (doesContain) {
            System.out.println("Strings are rotational");
        } else {
            System.out.println("Strings are not rotational");
        }
    }
}