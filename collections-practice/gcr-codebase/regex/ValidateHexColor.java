import java.util.Scanner;

class ValidateHexColor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter hex color:");
        String color = scn.nextLine();

        if (color.matches("^#[0-9a-fA-F]{6}$"))
            System.out.println("Valid Hex Color");
        else
            System.out.println("Invalid Hex Color");
    }
}
