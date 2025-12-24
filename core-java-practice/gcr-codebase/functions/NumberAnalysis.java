import java.util.Scanner;

class NumberAnalysis {
    static boolean isPositive(int number) {
        return number >= 0;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    static int compare(int first, int last) {
        if (first > last)
            return 1;
        if (first < last)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = scn.nextInt();
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println("Positive Even");
                } else {
                    System.out.println("Positive Odd");
                }
            } else {
                System.out.println("Negative");
            }
        }
        int res = compare(numbers[0], numbers[4]);
        System.out.println("Compare result " + res);
    }
}
