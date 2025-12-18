import java.util.Scanner;
public class CalculatePurchasePrice {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double unitPrice = scn.nextDouble();
        double quantity = scn.nextDouble();
        double purchasePrice = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + purchasePrice+ " if the quantity purchased is " + quantity + " and unit price is INR " + unitPrice);
    }
}
