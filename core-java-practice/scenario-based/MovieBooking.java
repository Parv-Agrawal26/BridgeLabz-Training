import java.util.Scanner;

class MovieBooking{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Enter movie type or exit");
            String movieType = scn.next();
            if (movieType.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Enter seat type gold or silver");
            String seatType = scn.next();
            int price = 0;
            switch (movieType) {
                case "action":
                    price = 200;
                    break;
                case "comedy":
                    price = 150;
                    break;
                case "drama":
                    price = 180;
                    break;
                default:
                    price = 120;
            }
            if (seatType.equalsIgnoreCase("gold")) {
                price = price + 100;
            }
            System.out.println("snacks yes or no");
            String snacks = scn.next();
            if (snacks.equalsIgnoreCase("yes")) {
                price = price + 50;
            }
            System.out.println("Total price " + price);
        }
    }
}
