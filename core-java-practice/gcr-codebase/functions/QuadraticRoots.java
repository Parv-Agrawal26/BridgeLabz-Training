import java.util.Scanner;

class QuadraticRoots {
    static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0)
            return new double[0];
        if (delta == 0) {
            return new double[] { -b / (2 * a) };
        }
        double root1 = (-b + Math.sqrt(delta)) / (2 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2 * a);
        return new double[] { root1, root2 };
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double a = scn.nextDouble();
        double b = scn.nextDouble();
        double c = scn.nextDouble();
        double[] roots = findRoots(a, b, c);
        for (int i = 0; i < roots.length; i++) {
            System.out.println("Root " + roots[i]);
        }
    }
}
