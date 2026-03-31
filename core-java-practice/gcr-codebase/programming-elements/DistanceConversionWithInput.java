import java.util.Scanner;

class DistanceConversionWithInput {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double kilometers = scn.nextDouble();

        double kilometerToMile = 1.6;

        double miles = kilometers / kilometerToMile;

        System.out.println(
                "The total miles is " + miles + " mile for the given " + kilometers + " km");
    }
}
