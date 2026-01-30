import java.util.Scanner;

class ValidateLicensePlate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter license plate:");
        String plate = scn.nextLine();

        if (plate.matches("[A-Z]{2}[0-9]{4}"))
            System.out.println("Valid License Plate");
        else
            System.out.println("Invalid License Plate");
    }
}
