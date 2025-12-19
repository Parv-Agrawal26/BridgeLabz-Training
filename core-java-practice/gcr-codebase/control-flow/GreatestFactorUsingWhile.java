import java.util.Scanner;
class GreatestFactorUsingWhile {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int greatestFactor = 1;
        int counter =number-1;
        while (counter>= 1) {
            if (number %counter == 0) {
                greatestFactor =counter;
                break;
            }
            counter--;
        }
        System.out.println("The greatest factor is " + greatestFactor);
    }
}
