import java.util.Scanner;

class SmallLarge {
    static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;
        if (number2 < smallest)
            smallest = number2;
        if (number3 < smallest)
            smallest = number3;
        if (number2 > largest)
            largest = number2;
        if (number3 > largest)
            largest = number3;
        return new int[] { smallest, largest };
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int num3 = scn.nextInt();
        int[] result = findSmallestAndLargest(num1, num2, num3);
        System.out.println("Smallest " + result[0]);
        System.out.println("Largest " + result[1]);
    }
}
