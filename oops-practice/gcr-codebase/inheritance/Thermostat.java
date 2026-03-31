class Device {
    String deviceId;
    boolean status;

    Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    int temperature;

    Thermostat(String deviceId, boolean status, int temperature) {
        super(deviceId, status);
        this.temperature = temperature;
    }

    void displayStatus() {
        System.out.println(deviceId + " " + status + " " + temperature);
    }

    public static void main(String[] args) {
        Thermostat t = new Thermostat("TH101", true, 24);
        t.displayStatus();
    }
}
