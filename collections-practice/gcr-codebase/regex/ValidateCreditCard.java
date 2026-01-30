import java.util.Scanner;

class ValidateCreditCard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter card number:");
        String card = scn.nextLine();

        if (card.matches("4\\d{15}") || card.matches("5\\d{15}"))
            System.out.println("Valid Card");
        else
            System.out.println("Invalid Card");
    }
}
