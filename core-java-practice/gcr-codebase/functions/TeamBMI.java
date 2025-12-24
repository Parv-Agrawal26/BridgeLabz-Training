import java.util.Scanner;

class TeamBMI {
    static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightMeter = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightMeter * heightMeter);
        }
    }

    static String[] findStatus(double[][] data) {
        String[] status = new String[10];
        for (int i = 0; i < 10; i++) {
            if (data[i][2] <= 18.4)
                status[i] = "Underweight";
            else if (data[i][2] <= 24.9)
                status[i] = "Normal";
            else if (data[i][2] <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double[][] data = new double[10][3];
        for (int i = 0; i < 10; i++) {
            data[i][0] = scn.nextDouble();
            data[i][1] = scn.nextDouble();
        }
        calculateBMI(data);
        String[] status = findStatus(data);
        for (int i = 0; i < 10; i++) {
            System.out.println(data[i][0] + " " + data[i][1] + " " + data[i][2] + " " + status[i]);
        }
    }
}
