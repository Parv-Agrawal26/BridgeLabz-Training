import java.util.Scanner;

class HeightConversion {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double heightInCentimeters = scn.nextDouble();

        double centimetersPerInch = 2.54;

        int inchesPerFoot = 12;

        double totalInches = heightInCentimeters / centimetersPerInch;

        int heightInFeet = (int) (totalInches / inchesPerFoot);

        double remainingInches = totalInches - (heightInFeet * inchesPerFoot);

        System.out.println(
                "Your Height in cm is " + heightInCentimeters +
                        " while in feet is " + heightInFeet +
                        " and inches is " + remainingInches);
    }
}
