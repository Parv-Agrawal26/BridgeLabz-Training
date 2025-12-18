import java.util.Scanner;

class FeeDiscountWithInput {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double fee = scn.nextDouble();

        double discountPercent = scn.nextDouble();

        double discount = (fee * discountPercent) / 100;

        double discountedFee = fee - discount;

        System.out.println(
                "The discount amount is INR " + discount +
                        " and final discounted fee is INR " + discountedFee);
    }
}
