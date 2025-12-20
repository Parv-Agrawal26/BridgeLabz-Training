import java.util.Scanner;
class BMIFitnessTracker {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double weight = scn.nextDouble();
        double height = scn.nextDouble();
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            System.out.println("BMI is " + bmi + " : Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("BMI is " + bmi + " : Normal");
        } else {
            System.out.println("BMI is " + bmi + " : Overweight");
        }
    }
}
