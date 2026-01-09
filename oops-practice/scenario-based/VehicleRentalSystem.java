public class VehicleRentalSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice", "DL12345");
        Customer customer2 = new Customer("Bob", "DL67890");

        Vehicle car1 = new Car("Toyota Camry", 50.0, 5);
        Vehicle bike1 = new Bike("Yamaha FZ", 20.0, true);
        Vehicle truck1 = new Truck("Ford F-150", 80.0, 1000.0);
        car1.rentVehicle(customer1);
        bike1.rentVehicle(customer2);
        truck1.rentVehicle(customer1);
        car1.returnVehicle(customer1);
        bike1.returnVehicle(customer2);
        truck1.returnVehicle(customer1);

        car1.calculateRentalCost(3);
        bike1.calculateRentalCost(2);
        truck1.calculateRentalCost(5);
    }
}

abstract class Vehicle implements Rentable {
    protected String name;
    protected String type;
    protected double rentalPricePerDay;
    protected boolean isAvailable;
    String rentedBy;
    Vehicle(String name, String type, double rentalPricePerDay) {
        this.name = name;
        this.type = type;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isAvailable = true;
    }
    void rentVehicle(Customer customer) {
        if(isAvailable) {
            isAvailable = false;
            rentedBy = customer.name;
            System.out.println(name + " has been rented.");
        } else {
            System.out.println(name + " is not available for rent.");
        }
    }
    void returnVehicle(Customer customer) {
        isAvailable = true;
        rentedBy = null;
        System.out.println(name + " has been returned.");
    }
}
class Car extends Vehicle{
    private int seatingCapacity;
    Car(String name, double rentalPricePerDay, int seatingCapacity) {
        super(name, "Car", rentalPricePerDay);
        this.seatingCapacity = seatingCapacity;
    }
    public void calculateRentalCost(int days) {
        double totalCost = rentalPricePerDay * days;
        System.out.println("Total rental cost for " + name + " for " + days + " days is: " + totalCost);
    }
}

class Bike extends Vehicle{
    private boolean hasCarrier;
    Bike(String name, double rentalPricePerDay, boolean hasCarrier) {
        super(name, "Bike", rentalPricePerDay);
        this.hasCarrier = hasCarrier;
    }

    public void calculateRentalCost(int days) {
        double totalCost = rentalPricePerDay * days;
        System.out.println("Total rental cost for " + name + " for " + days + " days is: " + totalCost);
    }
}

class Truck extends Vehicle{
    private double loadCapacity;
    Truck(String name, double rentalPricePerDay, double loadCapacity) {
        super(name, "Truck", rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }

    public void calculateRentalCost(int days) {
        double totalCost = rentalPricePerDay * days;
        System.out.println("Total rental cost for " + name + " for " + days + " days is: " + totalCost);
    }
}

class Customer {
    protected String name;
    protected String licenseNumber;
    Customer(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
}

interface Rentable {
    void calculateRentalCost(int days);
}