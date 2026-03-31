import java.util.Scanner;
class GreatestFactor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int greatestFactor = 1;
        if (number > 1) {
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
            }
        }
        System.out.println("The greatest factor is " + greatestFactor);
    }
}
