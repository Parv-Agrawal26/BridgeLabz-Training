interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private double rentalRate;

    Vehicle(String vehicleNumber, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.rentalRate = rentalRate;
    }

    double getRentalRate() {
        return rentalRate;
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    Car(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Car Insurance";
    }
}

class Bike extends Vehicle {
    Bike(String number, double rate) {
        super(number, rate);
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}
