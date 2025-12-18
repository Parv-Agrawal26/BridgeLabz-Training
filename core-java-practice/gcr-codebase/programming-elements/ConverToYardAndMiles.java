import java.util.Scanner;

class ConvertToYardAndMiles {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double distanceInFeet = scn.nextDouble();

        double feetPerYard = 3;

        double yardsPerMile = 1760;

        double distanceInYards = distanceInFeet / feetPerYard;

        double distanceInMiles = distanceInYards / yardsPerMile;

        System.out.println(
                "The distance in yards is " + distanceInYards +
                        " and the distance in miles is " + distanceInMiles);
    }
}
