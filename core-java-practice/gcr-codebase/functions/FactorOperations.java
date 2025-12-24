import java.util.Scanner;

class FactorOperations {
    static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    static int sum(int[] factors) {
        int total = 0;
        for (int i = 0; i < factors.length; i++) {
            total = total + factors[i];
        }
        return total;
    }

    static int product(int[] factors) {
        int prod = 1;
        for (int i = 0; i < factors.length; i++) {
            prod = prod * factors[i];
        }
        return prod;
    }

    static double sumOfSquares(int[] factors) {
        double total = 0;
        for (int i = 0; i < factors.length; i++) {
            total = total + Math.pow(factors[i], 2);
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int[] factors = findFactors(number);
        for (int i = 0; i < factors.length; i++) {
            System.out.println(factors[i]);
        }
        System.out.println("Sum " + sum(factors));
        System.out.println("Product " + product(factors));
        System.out.println("Sum of squares " + sumOfSquares(factors));
    }
}
