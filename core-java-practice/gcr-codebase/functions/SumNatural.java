import java.util.Scanner;

class SumNatural {
    static int findSum(int number) {
        int sum = 0;
        for (int index = 1; index <= number; index++) {
            sum = sum + index;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        System.out.println("Sum " + findSum(number));
    }
}
