import java.util.Scanner;

public class Program {
    static final RobotHazardAuditor auditor = new RobotHazardAuditor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Arm Precision (0.0 - 1.0):\n");
        double armPrecision = scanner.nextDouble();

        System.out.print("Enter Worker Density (1 - 20):\n");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); 

        System.out.print("Enter Machinery State (Worn/Faulty/Critical):\n");
        String machineryState = scanner.nextLine();

        calculateAndDisplayHazardRisk(armPrecision, workerDensity, machineryState);

        scanner.close();
    }

    public static void calculateAndDisplayHazardRisk(double armPrecision, int workerDensity, String machineryState) {
        try {
            double hazardRisk = auditor.CalculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }
}
