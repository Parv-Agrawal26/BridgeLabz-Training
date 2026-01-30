import java.util.Scanner;

class ValidateIPAddress {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter IP address:");
        String ip = scn.nextLine();

        String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        if (ip.matches(regex))
            System.out.println("Valid IP");
        else
            System.out.println("Invalid IP");
    }
}
