public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateCost() {
        return rentalDays * 1000;
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Suresh", "Sedan", 3);
        System.out.println("Total Cost " + rental.calculateCost());
    }
}
