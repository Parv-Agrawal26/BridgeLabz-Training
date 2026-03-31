import java.util.Scanner;
class NumberCheck {
    static int checkNumber(int value) {
        if (value > 0)
            return 1;
        if (value < 0)
            return -1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int result = checkNumber(number);
        System.out.println(result);
    }
}
