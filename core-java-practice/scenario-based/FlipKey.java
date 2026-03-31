import java.util.Scanner;

public class FlipKey {

    public static String CleanseAndInvert(String input) {

        if (input == null || input.length() < 6) {
            return "";
        }
        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            if (!Character.isLetter(currentChar)) {
                return "";
            }
        }
        input = input.toLowerCase();
        StringBuilder filteredText = new StringBuilder();

        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);
            int asciiValue = (int) currentChar;

            if (asciiValue % 2 != 0) {
                filteredText.append(currentChar);
            }
        }
        filteredText.reverse();

        for (int index = 0; index < filteredText.length(); index++) {
            char currentChar = filteredText.charAt(index);

            if (index % 2 == 0) {
                filteredText.setCharAt(index, Character.toUpperCase(currentChar));
            }
        }

        return filteredText.toString();
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the word");
        String input = scn.nextLine();

        String result = CleanseAndInvert(input);
        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }
    }
}
