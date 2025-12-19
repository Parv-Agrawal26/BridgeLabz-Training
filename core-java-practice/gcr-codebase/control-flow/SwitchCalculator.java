import java.util.Scanner;
class SwitchCalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double first = scn.nextDouble();
        double second = scn.nextDouble();
        String op = scn.next();
        switch (op) {
            case "+":
                System.out.println(first + second);
                break;
            case "-":
                System.out.println(first - second);
                break;
            case "*":
                System.out.println(first * second);
                break;
            case "/":
                if (second != 0) {
                    System.out.println(first / second);
                } else {
                    System.out.println("Division by zero not allowed");
                }
                break;
            default:
                System.out.println("Invalid Operator");
        }
    }
}
