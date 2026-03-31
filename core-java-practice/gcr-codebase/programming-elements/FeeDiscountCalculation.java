class FeeDiscountCalculation {

    public static void main(String[] args) {

        double fee = 125000;

        double discountPercent = 10;

        double discount = (fee * discountPercent) / 100;

        double discountedFee = fee - discount;

        System.out.println(
                "The Discount Amount is INR " + discount +
                        " and the Fee to be Paid is INR " + discountedFee);
    }
}