public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println(ownerName + " " + vehicleType + " " + registrationFee);
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Aman", "Bike");
        v1.displayVehicleDetails();
        Vehicle.updateRegistrationFee(800);
        v1.displayVehicleDetails();
    }
}
