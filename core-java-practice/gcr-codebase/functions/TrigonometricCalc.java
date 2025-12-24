import java.util.Scanner;

class TrigonometricCalc {
    static double[] calculateTrigonometricFunctions(double angle) {
        double radian = Math.toRadians(angle);
        double sinVal = Math.sin(radian);
        double cosVal = Math.cos(radian);
        double tanVal = Math.tan(radian);
        return new double[] { sinVal, cosVal, tanVal };
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double angle = scn.nextDouble();
        double[] result = calculateTrigonometricFunctions(angle);
        System.out.println("Sine " + result[0]);
        System.out.println("Cosine " + result[1]);
        System.out.println("Tangent " + result[2]);
    }
}
