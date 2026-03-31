import java.util.Scanner;

class TriangularParkRun {
    static double findRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000;
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double first = scn.nextDouble();
        double second = scn.nextDouble();
        double third = scn.nextDouble();
        double rounds = findRounds(first, second, third);
        System.out.println("Rounds needed " + rounds);
    }
}
