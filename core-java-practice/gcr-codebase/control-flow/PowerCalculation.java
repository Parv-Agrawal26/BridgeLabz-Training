import java.util.Scanner;
class PowerCalculation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int power= scn.nextInt();
        int result =1;
        if (number >0 && power>= 0) {
            for (int i = 1; i <= power; i++) {
                result= result * number;
            }
            System.out.println("The power result is " + result);
        } else {
            System.out.println("Invalid input");
        }
    }
}
