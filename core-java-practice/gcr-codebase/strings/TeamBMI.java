import java.util.Scanner;
class TeamBMI{
    static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[10][4];
        for (int index = 0; index < 10; index++) {
            double weight = data[index][0];
            double heightMeter = data[index][1] / 100;
            double bmi = weight / (heightMeter * heightMeter);
            result[index][0] = String.valueOf(data[index][1]);
            result[index][1] = String.valueOf(weight);
            result[index][2] = String.valueOf(bmi);
            if (bmi <= 18.4)
                result[index][3] = "Underweight";
            else if (bmi <= 24.9)
                result[index][3] = "Normal";
            else if (bmi <= 39.9)
                result[index][3] = "Overweight";
            else
                result[index][3] = "Obese";
        }
        return result;
    }
    static void display(String[][] res) {
        for (int row = 0; row < res.length; row++) {
            System.out.println(res[row][0] + " " + res[row][1] + " " + res[row][2] + " " + res[row][3]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double[][] input = new double[10][2];
        for (int i = 0; i < 10; i++) {
            input[i][0] = scn.nextDouble();
            input[i][1] = scn.nextDouble();
        }
        String[][] output = calculateBMI(input);
        display(output);
    }
}
