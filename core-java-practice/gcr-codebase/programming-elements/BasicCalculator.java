import java.util.Scanner;

class BasicCalculator {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double number1 = scn.nextDouble();
        double number2 = scn.nextDouble();

        double additionResult = number1 + number2;
        double subtractionResult = number1 - number2;
        double multiplicationResult = number1 * number2;
        double divisionResult = number1 / number2;

        System.out.println(
                "The addition, subtraction, multiplication and division value of 2 numbers " +
                        number1 + " and " + number2 + " is " +
                        additionResult + ", " +
                        subtractionResult + ", " +
                        multiplicationResult + ", and " +
                        divisionResult);
    }
}
