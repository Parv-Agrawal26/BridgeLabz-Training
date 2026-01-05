interface GPS {
    String getCurrentLocation();

    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    Vehicle(String id, String driver, double rate) {
        vehicleId = id;
        driverName = driver;
        ratePerKm = rate;
    }

    double getRate() {
        return ratePerKm;
    }

    abstract double calculateFare(double distance);

    void getVehicleDetails() {
        System.out.println(driverName + " " + vehicleId);
    }
}

class Car extends Vehicle implements GPS {
    Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    double calculateFare(double distance) {
        return distance * getRate();
    }

    public String getCurrentLocation() {
        return "City Center";
    }

    public void updateLocation(String location) {
        System.out.println("Location updated");
    }
}
