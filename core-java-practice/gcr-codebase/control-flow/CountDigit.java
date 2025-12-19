import java.util.Scanner;

class CountDigit {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int count = 0;
        if (number == 0) {
            count = 1;
        } else {
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }
        System.out.println("The number of digits is " + count);
    }
}
