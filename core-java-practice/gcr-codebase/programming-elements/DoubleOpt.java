import java.util.Scanner;

class DoubleOpt {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double a = scn.nextDouble();
        double b = scn.nextDouble();
        double c = scn.nextDouble();

        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
    }
}
