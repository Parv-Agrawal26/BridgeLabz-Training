import java.util.Scanner;

class SquareSideCalculation {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        double perimeter = scn.nextDouble();
        double sideLength = perimeter / 4;
        System.out.println("The length of the side is " + sideLength + " whose perimeter is " + perimeter);
    }
}
