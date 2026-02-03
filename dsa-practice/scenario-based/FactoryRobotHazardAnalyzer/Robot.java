public class Robot {
    private double armPrecision;
    private int workerDensity;
    private String machineryState;

    public Robot(double armPrecision, int workerDensity, String machineryState) {
        this.armPrecision = armPrecision;
        this.workerDensity = workerDensity;
        this.machineryState = machineryState;
    }

    public double getArmPrecision() {
        return armPrecision;
    }

    public int getWorkerDensity() {
        return workerDensity;
    }

    public String getMachineryState() {
        return machineryState;
    }
}
