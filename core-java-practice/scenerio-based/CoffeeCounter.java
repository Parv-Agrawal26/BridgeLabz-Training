import java.util.Scanner;
class CoffeeCounter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            String coffeeType = scn.next();
            if (coffeeType.equals("exit")) {
                break;
            }
            int quantity = scn.nextInt();
            double price = 0;
            switch (coffeeType) {
                case "espresso":
                    price = 100;
                    break;
                case "latte":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 150;
                    break;
                case "americano":
                    price = 180;
                    break;
                default:
                    System.out.println("Invalid Coffee Type");
                    continue;
            }
            double total = price * quantity;
            double gst = total * 0.05;
            double finalBill = total + gst;
            System.out.println("Total Bill with GST is " + finalBill);
        }
    }
}