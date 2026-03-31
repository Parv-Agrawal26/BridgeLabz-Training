interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends Vehicle {
    ElectricVehicle(int speed, String model) {
        super(speed, model);
    }

    void charge() {
        System.out.println("Vehicle charging");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(int speed, String model) {
        super(speed, model);
    }

    public void refuel() {
        System.out.println("Vehicle refueled");
    }
}
