import java.util.Scanner;

class TriangleAreaCalculation {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double baseInInches = scn.nextDouble();
        double heightInInches = scn.nextDouble();

        double areaInSquareInches = 0.5 * baseInInches * heightInInches;

        double centimetersPerInch = 2.54;

        double baseInCentimeters = baseInInches * centimetersPerInch;
        double heightInCentimeters = heightInInches * centimetersPerInch;

        double areaInSquareCentimeters = 0.5 * baseInCentimeters * heightInCentimeters;

        System.out.println(
                "The area of the triangle in square inches is " + areaInSquareInches +
                        " and in square centimeters is " + areaInSquareCentimeters);
    }
}
